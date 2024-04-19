# Project-Safarate-AlloBaba
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Git Workflow</title>
</head>
<body>
    <h1> 1)lab4iti te puller:</h1>
    <h2># dans votre branche</h2>
    <code>git pull origin main</code>
    <h1>2)lb4iti te pusher</h2>
    <h3>Étape 1: Pusher les modifications depuis votre branche locale vers la branche distante</h3>
    <h2># dans votre branche</h2>
    <code>git add .</code><br>
    <code>git commit -m "votre_message_de_commit"</code><br>
    <code>git push origin feature/mohammed</code>
<h3></h3>
    <h3>Étape 2: Fusionner les modifications dans la branche principale (main)</h3>
    <p>
        Assurez-vous d'être sur la branche principale (main) :
    </p>
    <h2>#dans votre branche main</h2>
    <code>git checkout main</code><br>
    <code>git merge feature/mohammed</code><br>
    <code>git push origin main</code>
    <h3></h3>
    <h3>sorte Branche main to your Branche</h3>
    <p>
        :
    </p>
    <h2>#dans  branche main</h2>
    <code>git checkout your_branche_name</code><br>
</body>
</html>
