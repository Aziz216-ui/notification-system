# Configuration GitHub pour le Notification System

## 🚀 Étapes pour publier sur GitHub

### 1. Créer le dépôt GitHub
1. Allez sur https://github.com
2. Cliquez sur "New repository"
3. Nom du dépôt : `notification-system`
4. Description : `Système de notification en temps réel avec Spring Boot et WebSocket`
5. Choisissez "Public" ou "Private"
6. NE cochez PAS "Add a README file" (nous en avons déjà un)
7. Cliquez sur "Create repository"

### 2. Connecter votre projet local à GitHub

#### Option A : Via HTTPS (recommandé)
```bash
# Remplacez VOTRE_USERNAME par votre nom d'utilisateur GitHub
git remote add origin https://github.com/VOTRE_USERNAME/notification-system.git
git branch -M main
git push -u origin main
```

#### Option B : Via SSH (si vous avez configuré les clés SSH)
```bash
git remote add origin git@github.com:VOTRE_USERNAME/notification-system.git
git branch -M main
git push -u origin main
```

### 3. Authentification GitHub

#### Si vous utilisez HTTPS :
- GitHub vous demandera votre username et password/token
- Utilisez un Personal Access Token (PAT) au lieu de votre password
- Créez un PAT ici : https://github.com/settings/tokens

#### Créer un Personal Access Token :
1. Allez dans Settings > Developer settings > Personal access tokens
2. Cliquez sur "Generate new token"
3. Cochez les permissions : `repo` (contrôle complet des dépôts)
4. Générez le token et copiez-le (il ne sera plus affiché)

### 4. Vérifier le déploiement

#### Commandes pour vérifier :
```bash
# Vérifier les remotes
git remote -v

# Vérifier le statut
git status

# Voir les commits
git log --oneline
```

#### URLs après déploiement :
- **Dépôt principal** : `https://github.com/VOTRE_USERNAME/notification-system`
- **README** : Visible sur la page principale du dépôt
- **Issues** : `https://github.com/VOTRE_USERNAME/notification-system/issues`
- **Pull Requests** : `https://github.com/VOTRE_USERNAME/notification-system/pulls`

## 🛠️ Configuration avancée

### Activer GitHub Pages (optionnel)
Si vous voulez héberger la documentation :

1. Allez dans Settings > Pages
2. Source : Deploy from a branch
3. Branch : main
4. Folder : /root
5. Cliquez sur Save

Votre documentation sera accessible à :
`https://VOTRE_USERNAME.github.io/notification-system`

### Ajouter un badge de build
Ajoutez ce badge dans votre README.md :

```markdown
![Build Status](https://github.com/VOTRE_USERNAME/notification-system/workflows/CI/badge.svg)
```

### Configurer GitHub Actions
Créez le fichier `.github/workflows/ci.yml` :

```yaml
name: CI

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  build:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v3
    
    - name: Set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'
        
    - name: Cache Maven packages
      uses: actions/cache@v3
      with:
        path: ~/.m2
        key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
        
    - name: Run tests
      run: mvn clean test
      
    - name: Build project
      run: mvn clean package -DskipTests
```

## 📝 Commandes Git utiles

### Workflow quotidien
```bash
# Vérifier les changements
git status

# Ajouter des fichiers
git add .

# Commiter avec message
git commit -m "Description des changements"

# Push vers GitHub
git push origin main
```

### Gestion des branches
```bash
# Créer une nouvelle branche
git checkout -b feature/nouvelle-fonctionnalite

# Switcher de branche
git checkout main

# Merger une branche
git merge feature/nouvelle-fonctionnalite

# Supprimer une branche
git branch -d feature/nouvelle-fonctionnalite
```

### Synchronisation
```bash
# Récupérer les changements du distant
git pull origin main

# Voir les différences
git diff HEAD~1

# Voir l'historique
git log --graph --oneline
```

## 🔧 Personnalisation

### Ajouter une license
1. Allez dans votre dépôt GitHub
2. Cliquez sur "Add file"
3. Nom : `LICENSE`
4. Choisissez "MIT License" (ou autre)
5. Complétez les informations
6. Committez

### Ajouter des templates
- **Issue template** : `.github/ISSUE_TEMPLATE/bug_report.md`
- **Pull request template** : `.github/PULL_REQUEST_TEMPLATE.md`
- **Contributing guidelines** : `CONTRIBUTING.md`

### Exemple de bug report template
```markdown
---
name: Bug Report
about: Create a report to help us improve
title: ''
labels: bug
assignees: ''
---

**Describe the bug**
Une description claire et concise du bug.

**To Reproduce**
Étapes pour reproduire le comportement :
1. Aller à '...'
2. Cliquer sur '....'
3. Faire défiler jusqu'à '....'
4. Voir l'erreur

**Expected behavior**
Une description de ce que vous vous attendiez à ce qui se passe.

**Screenshots**
Si applicable, ajoutez des captures d'écran pour aider à expliquer votre problème.

**Environment:**
- OS: [ex: Windows 10, macOS 11.0]
- Navigateur: [ex: Chrome, Firefox]
- Version: [ex: 1.0.0]

**Additional context**
Ajoutez tout autre contexte sur le problème ici.
```

## 🚀 Prochaines étapes

1. **Push initial** : Poussez votre code vers GitHub
2. **Configuration** : Ajoutez des badges et configurez GitHub Actions
3. **Documentation** : Améliorez le README si nécessaire
4. **Tests** : Assurez-vous que tous les tests passent
5. **Release** : Créez votre première release quand prêt

### Créer une release
1. Allez dans Releases > "Create a new release"
2. Tag version : `v1.0.0`
3. Release title : `Version 1.0.0`
4. Description : Décrivez les fonctionnalités
5. Cliquez sur "Publish release"

Votre projet est maintenant prêt pour GitHub ! 🎉
