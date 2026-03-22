
Notification System
Real-time notification system built with Spring Boot and WebSocket for instant bidirectional communication.

Java Spring Boot WebSocket License

Overview
A robust real-time notification system that enables instant communication between server and clients using WebSocket technology. Perfect for e-commerce order tracking, live dashboards, chat applications, and mobile alert systems.

Features
Real-time Communication - Instant bidirectional messaging via WebSocket
Order Management - Complete order status tracking system
Admin Interface - intuitive dashboard for system management
Client Interface - User-friendly notification display
STOMP Protocol - Reliable messaging over WebSocket
Cross-origin Support - Configurable CORS for multiple domains
Quick Start
# Clone the repository
git clone https://github.com/Aziz216-ui/notification-system.git
cd notification-system

# Launch the application
mvn spring-boot:run
Access the application at:

Admin Dashboard: http://localhost:8086/order.html
Client Interface: http://localhost:8086/order-user-client.html
Requirements
Java 17 or higher
Maven 3.6 or higher
Modern web browser with WebSocket support
Architecture
┌─────────────────┐    WebSocket/STOMP    ┌─────────────────┐
│   Admin UI      │ ◄──────────────────► │  Spring Boot    │
│  (order.html)   │                       │   Application   │
└─────────────────┘                       │                 │
                                          │  WebSocket      │
┌─────────────────┐                       │  Controller     │
│   Client UI     │ ◄──────────────────► │                 │
│(order-user-     │                       └─────────────────┘
│ client.html)    │
└─────────────────┘
API Reference
WebSocket Endpoints
Endpoint	Purpose	Direction
/ws	WebSocket connection	Client → Server
/topic/notifications	General notifications	Server → Client
/topic/order	Order updates	Server → Client
Message Examples
Send Notification

stompClient.send("/app/sendMessage", {}, "Your message here");
Update Order Status

const orderUpdate = {
    orderId: "ORD-001",
    status: "SHIPPED"
};
stompClient.send("/app/order/status", {}, JSON.stringify(orderUpdate));
Subscribe to Updates

stompClient.subscribe('/topic/notifications', function(message) {
    handleNotification(JSON.parse(message.body));
});
Installation
Development Environment
# Clone and build
git clone https://github.com/Aziz216-ui/notification-system.git
cd notification-system
mvn clean compile

# Run tests
mvn test

# Start application
mvn spring-boot:run
Production Deployment
# Build for production
mvn clean package -DskipTests

# Deploy
java -jar target/notification-system-0.0.1-SNAPSHOT.jar
Docker Deployment
# Build image
docker build -t notification-system .

# Run container
docker run -p 8086:8086 notification-system
Configuration
WebSocket Configuration
// WebSocketConfig.java
@Override
public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/ws")
            .setAllowedOrigins("http://localhost:63342", "http://localhost:8086")
            .withSockJS();
}
Application Properties
server.port=8086
websocket.allowed-origins=http://localhost:63342,http://localhost:8086
logging.level.com.aziz.notification_system=INFO
Use Cases
E-commerce Platforms - Real-time order status updates
Mobile Applications - Push notifications and alerts
Chat Systems - Instant messaging functionality
Monitoring Dashboards - Live data updates
Gaming Applications - Multiplayer notifications
Contributing
Fork the repository
Create a feature branch (git checkout -b feature/amazing-feature)
Commit your changes (git commit -m 'Add amazing feature')
Push to the branch (git push origin feature/amazing-feature)
Open a Pull Request
Development Guidelines
Follow Spring Boot best practices
Write comprehensive tests for new features
Update documentation for API changes
Use meaningful commit messages
Ensure code follows existing style conventions
Testing
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=NotificationControllerTest

# Generate test coverage report
mvn clean test jacoco:report

Performance Considerations
WebSocket connections are lightweight and efficient
STOMP protocol ensures reliable message delivery
SockJS provides fallback for browsers without WebSocket support
Configurable connection timeouts and retry policies
Security
CORS configuration for cross-origin requests
Configurable allowed origins
WebSocket endpoint security
Input validation for message payloads
Troubleshooting
Common Issues
WebSocket Connection Failed

Verify port 8086 is available
Check CORS configuration
Ensure browser supports WebSocket
Messages Not Received

Verify subscription to correct topic
Check browser console for errors
Confirm server is running
Debug Commands
# Check application logs
tail -f logs/application.log

# Monitor WebSocket connections
curl -i -N -H "Connection: Upgrade" \
     -H "Upgrade: websocket" \
     -H "Sec-WebSocket-Key: test" \
     -H "Sec-WebSocket-Version: 13" \
     http://localhost:8086/ws
License
This project is licensed under the MIT License - see the LICENSE file for details.

Author
Aziz - Software Engineer specializing in Java/Spring Boot and real-time systems.

GitHub: Aziz216-ui
Acknowledgments
Spring Boot framework
WebSocket technology
STOMP messaging protocol
SockJS WebSocket fallback
⭐ If this project helps you, consider giving it a star on GitHub.
