echo "==================="
echo "Java Mod Loader for BlockLauncher(Android) builder"
echo "==================="
echo "Starting build..."
$webClient=New-Object -TypeName System.Net.WebClient
echo "Downloading latest js file..."
$jsFile=$webClient.DownloadString("https://github.com/nao20010128nao/DexModLoader-Android/raw/master/jsSrc/main.js")
echo "Downloading latest jar file..."
$webClient.DownloadFile("https://github.com/nao20010128nao/DexModLoader-Android/raw/master/resources/app.jar","./file.jar")
echo "Converting jar file..."
[System.Diagnostics.Process]::Start("java","-jar ./dx/lib/dx.jar --dex --multi-dex --main-dex-list=./file.jar ./dex.dex").WaitForExit()
$jfB64=[System.Convert]::ToBase64String($jarFile)
echo "Making js file..."
$jsResult=$jsFile.Replace("%mainDex%",$jfB64)
echo "Downloading latest jar file..."
