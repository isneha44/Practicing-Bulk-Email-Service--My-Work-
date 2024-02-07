package main

import (
	"bufio"
	"crypto/tls"
	"encoding/base64"
	"fmt"
	"log"
	"net"
	"net/smtp"
	"strings"
)

func main() {
	listener, err := net.Listen("tcp", "localhost:2525")
	if err != nil {
		log.Fatal("Error listening:", err)
		return
	}
	defer listener.Close()
	fmt.Println("SMTP server is listening on localhost:2525")

	for {
		conn, err := listener.Accept()
		if err != nil {
			log.Println("Error accepting connection:", err)
			continue
		}
		go handleConnection(conn)
	}
}

func handleConnection(conn net.Conn) {
	defer conn.Close()
	fmt.Println("Client connected:", conn.RemoteAddr())

	conn.Write([]byte("220 Welcome to My SMTP Server\r\n"))

	tlsConfig := &tls.Config{
		InsecureSkipVerify: true,
		ServerName:         "localhost",
	}

	conn = tls.Server(conn, tlsConfig)

	scanner := bufio.NewScanner(conn)

	for scanner.Scan() {
		command := scanner.Text()
		fmt.Println("Client command:", command)

		if strings.HasPrefix(command, "QUIT") {
			conn.Write([]byte("221 Goodbye\r\n"))
			fmt.Println("Client disconnected:", conn.RemoteAddr())
			return
		}

		if strings.HasPrefix(command, "EHLO") || strings.HasPrefix(command, "HELO") {
			conn.Write([]byte("250 Hello\r\n"))
		}

		if strings.HasPrefix(command, "AUTH LOGIN") {
			conn.Write([]byte("334 VXNlcm5hbWU6\r\n")) // Username prompt
			scanner.Scan()
			username := base64Decode(scanner.Text())

			conn.Write([]byte("334 UGFzc3dvcmQ6\r\n")) // Password prompt
			scanner.Scan()
			password := base64Decode(scanner.Text())

			// Validate username and password (simplified for demonstration)
			if validateCredentials(username, password) {
				conn.Write([]byte("235 Authentication successful\r\n"))
			} else {
				conn.Write([]byte("535 Authentication failed\r\n"))
			}
		}

		// Handle other SMTP commands as needed
	}
}

func base64Decode(encoded string) string {
	decoded, _ := base64.StdEncoding.DecodeString(encoded)
	return string(decoded)
}

func validateCredentials(username, password string) bool {
	// Add your authentication logic here
	return username == "your_username" && password == "your_password"
}
