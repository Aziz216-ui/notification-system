Notification System
Un système de notification en temps réel construit avec Spring Boot et WebSocket, permettant la communication bidirectionnelle entre les clients et le serveur.

🚀 Fonctionnalités
Notifications en temps réel : Envoi et réception de messages instantanés via WebSocket
Gestion des commandes : Interface d'administration pour mettre à jour le statut des commandes
Interface client : Visualisation automatique des mises à jour de commandes
Communication bidirectionnelle : Support STOMP sur WebSocket avec SockJS
🏗️ Architecture
Backend (Spring Boot 4.0.4)
WebSocketConfig : Configuration des endpoints WebSocket (/ws) et des topics (/topic)
NotificationController : Gestionnaire des messages et mises à jour
OrderUpdate : Modèle de données pour les mises à jour de commande
Frontend (HTML/JavaScript)
order.html : Interface d'administration pour mettre à jour les statuts
order-user-client.html : Interface client pour visualiser les mises à jour
index_user.html : Interface de notification simple
📋 Prérequis
Java 17 ou supérieur
Maven 3.6 ou supérieur
Navigateur web moderne avec support WebSocket
🛠️ Installation
Cloner le dépôt

git clone https://github.com/votre-username/notification-system.git
cd notification-system
Compiler le projet

mvn clean compile
Lancer l'application

mvn spring-boot:run
L'application démarrera sur http://localhost:8086

🌐 Utilisation
Interface d'administration
Accédez à http://localhost:8086/order.html pour :

Mettre à jour le statut des commandes
Envoyer des notifications aux clients
Interface client
Accédez à http://localhost:8086/order-user-client.html pour :

Visualiser les mises à jour de commandes en temps réel
Recevoir les notifications instantanément
🔧 Configuration
WebSocket Endpoints
Endpoint : /ws (avec SockJS fallback)
Topics :
/topic/notifications : Messages généraux
/topic/order : Mises à jour de commandes
Origines autorisées
http://localhost:63342
http://localhost:8086
http://127.0.0.1:8086
http://localhost
📦 Dépendances
Spring Boot Starter WebMVC
Spring Boot Starter WebSocket
Spring Boot Starter Thymeleaf
Spring Boot Starter Test
🧪 Tests
mvn test
📝 API
WebSocket Messages
Envoyer une notification
stompClient.send("/app/sendMessage", {}, "Votre message");
Mettre à jour une commande
const orderUpdate = {
    orderId: "ORD-001",
    status: "SHIPPED"
};
stompClient.send("/app/order/status", {}, JSON.stringify(orderUpdate));
S'abonner aux notifications
stompClient.subscribe('/topic/notifications', function(message) {
    console.log('Notification:', message.body);
});
S'abonner aux mises à jour de commande
stompClient.subscribe('/topic/order', function(message) {
    const orderUpdate = JSON.parse(message.body);
    console.log('Order update:', orderUpdate);
});
🚀 Déploiement
Production
# Compiler pour la production
mvn clean package

# Lancer le JAR
java -jar target/notification-system-0.0.1-SNAPSHOT.jar
Docker (optionnel)
# Construire l'image
docker build -t notification-system .

# Lancer le conteneur
docker run -p 8086:8086 notification-system
🔍 Dépannage
Problèmes courants
WebSocket ne se connecte pas

Vérifiez que le port 8086 est disponible
Assurez-vous que les origines sont correctement configurées
Messages non reçus

Vérifiez la console du navigateur pour les erreurs
Confirmez que vous êtes bien abonné au bon topic
🤝 Contribuer
Fork le projet
Créer une branche (git checkout -b feature/nouvelle-fonctionnalite)
Commiter les changements (git commit -am 'Ajouter nouvelle fonctionnalité')
Pusher la branche (git push origin feature/nouvelle-fonctionnalite)
Créer une Pull Request
📄 Licence
Ce projet est sous licence MIT. Voir le fichier LICENSE pour plus de détails.

👨‍💻 Auteur
Aziz - Développeur Java/Spring Boot

📞 Contact
Pour toute question ou suggestion, n'hésitez pas à créer une issue sur GitHub.
