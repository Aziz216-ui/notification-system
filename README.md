# Notification System
});
```

#### S'abonner aux mises à jour de commande
```javascript
stompClient.subscribe('/topic/order', function(message) {
    const orderUpdate = JSON.parse(message.body);
    console.log('Order update:', orderUpdate);
});
```

## 🚀 Déploiement

### Production
```bash
# Compiler pour la production
mvn clean package

# Lancer le JAR
java -jar target/notification-system-0.0.1-SNAPSHOT.jar
```

### Docker (optionnel)
```bash
# Construire l'image
docker build -t notification-system .

# Lancer le conteneur
docker run -p 8086:8086 notification-system
```

## 🔍 Dépannage

### Problèmes courants
1. **WebSocket ne se connecte pas**
   - Vérifiez que le port 8086 est disponible
   - Assurez-vous que les origines sont correctement configurées

2. **Messages non reçus**
   - Vérifiez la console du navigateur pour les erreurs
   - Confirmez que vous êtes bien abonné au bon topic

## 🤝 Contribuer

1. Fork le projet
2. Créer une branche (`git checkout -b feature/nouvelle-fonctionnalite`)
3. Commiter les changements (`git commit -am 'Ajouter nouvelle fonctionnalité'`)
4. Pusher la branche (`git push origin feature/nouvelle-fonctionnalite`)
5. Créer une Pull Request

## 📄 Licence

Ce projet est sous licence MIT. Voir le fichier LICENSE pour plus de détails.

## 👨‍💻 Auteur

**Aziz** - Développeur Java/Spring Boot

## 📞 Contact

Pour toute question ou suggestion, n'hésitez pas à créer une issue sur GitHub.
