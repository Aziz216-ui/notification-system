# Guide de Déploiement

## 📋 Commandes Essentielles

### Développement Local
```bash
# Nettoyer et compiler
mvn clean compile

# Lancer en mode développement
mvn spring-boot:run

# Lancer avec un profil spécifique
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Tests
```bash
# Exécuter tous les tests
mvn test

# Exécuter les tests avec coverage
mvn clean test jacoco:report

# Ignorer les tests pendant le build
mvn clean package -DskipTests
```

### Production
```bash
# Compiler pour la production
mvn clean package

# Lancer l'application
java -jar target/notification-system-0.0.1-SNAPSHOT.jar

# Lancer avec un profil spécifique
java -jar target/notification-system-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```

### Docker
```bash
# Créer l'image Docker
docker build -t notification-system .

# Lancer le conteneur
docker run -p 8086:8086 --name notification-app notification-system

# Lancer en arrière-plan
docker run -d -p 8086:8086 --name notification-app notification-system

# Voir les logs
docker logs notification-app

# Arrêter le conteneur
docker stop notification-app
```

## 🚀 Déploiement sur GitHub

### 1. Initialiser Git (si pas déjà fait)
```bash
git init
git add .
git commit -m "Initial commit - Notification System"
```

### 2. Ajouter le remote GitHub
```bash
git remote add origin https://github.com/votre-username/notification-system.git
git branch -M main
git push -u origin main
```

### 3. Premier push
```bash
git push origin main
```

## 🌐 Configuration GitHub Pages (Optionnel)

### Créer un fichier `.github/workflows/deploy.yml`
```yaml
name: Deploy to GitHub Pages

on:
  push:
    branches: [ main ]

jobs:
  build-and-deploy:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v3
    
    - name: Set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'
        
    - name: Build with Maven
      run: mvn clean package -DskipTests
      
    - name: Deploy to GitHub Pages
      uses: peaceiris/actions-gh-pages@v3
      with:
        github_token: ${{ secrets.GITHUB_TOKEN }}
        publish_dir: ./target/classes/static
```

## 🔧 Configuration Environnement

### Variables d'environnement
```bash
# Port de l'application
export SERVER_PORT=8086

# Profile Spring
export SPRING_PROFILES_ACTIVE=prod

# Configuration WebSocket (si nécessaire)
export WEBSOCKET_ALLOWED_ORIGINS=http://votredomaine.com
```

### Fichier `application.properties`
```properties
# Configuration serveur
server.port=8086

# Configuration WebSocket
websocket.allowed-origins=http://localhost:63342,http://localhost:8086,http://127.0.0.1:8086,http://localhost

# Logging
logging.level.com.aziz.notification_system=INFO
logging.level.org.springframework.web.socket=DEBUG
```

## 📊 Monitoring

### Actuator (Optionnel)
Ajouter au `pom.xml`:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

Endpoints disponibles:
- `http://localhost:8086/actuator/health`
- `http://localhost:8086/actuator/info`
- `http://localhost:8086/actuator/metrics`

## 🚨 Dépannage Déploiement

### Problèmes Communs
1. **Port déjà utilisé**
   ```bash
   # Trouver le processus utilisant le port
   netstat -tulpn | grep :8086
   
   # Tuer le processus
   kill -9 <PID>
   ```

2. **Mémoire insuffisante**
   ```bash
   # Lancer avec plus de mémoire
   java -Xmx2g -Xms1g -jar target/notification-system-0.0.1-SNAPSHOT.jar
   ```

3. **Problèmes de CORS**
   - Vérifier les origines configurées dans `WebSocketConfig`
   - Ajouter votre domaine dans `setAllowedOrigins()`

### Logs Utiles
```bash
# Voir les logs en temps réel
tail -f logs/application.log

# Logs spécifiques WebSocket
grep "WebSocket" logs/application.log
```

## 🔄 CI/CD avec GitHub Actions

### Workflow complet
```yaml
name: CI/CD Pipeline

on:
  push:
    branches: [ main, develop ]
  pull_request:
    branches: [ main ]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
    - uses: actions/checkout@v3
    - name: Set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'
    - name: Run tests
      run: mvn clean test
      
  build:
    needs: test
    runs-on: ubuntu-latest
    steps:
    - uses: actions/checkout@v3
    - name: Set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'
    - name: Build application
      run: mvn clean package -DskipTests
      
  deploy:
    needs: build
    runs-on: ubuntu-latest
    if: github.ref == 'refs/heads/main'
    steps:
    - uses: actions/checkout@v3
    - name: Deploy to production
      run: echo "Deploy step here"
```

## 📝 Checklist Déploiement

- [ ] Tests passent avec succès
- [ ] Build en production fonctionne
- [ ] Configuration WebSocket vérifiée
- [ ] Documentation à jour
- [ ] Version tagguée
- [ ] Backup de la version précédente
- [ ] Monitoring configuré
- [ ] Logs vérifiés
