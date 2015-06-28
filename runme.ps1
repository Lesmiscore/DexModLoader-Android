echo "==================="
echo "Java Mod Loader for BlockLauncher(Android) builder"
echo "==================="
echo "Starting build..."
$webClient=New-Object -TypeName System.Net.WebClient
echo "Downloading latest js file..."
$jsFile=$webClient.DownloadString("https://github.com/nao20010128nao/DexModLoader-Android/raw/master/jsSrc/main.js")
echo "Downloading latest jar file..."
$webClient.DownloadFile("https://github.com/nao20010128nao/DexModLoader-Android/raw/master/resources/app.jar")
echo "Converting jar file..."
[System.Diagnostics.Process]::Start([System.Environment]::GetEnvironmentVariable("ComSpec"),"/c ./dx/dx.bat --dex").WaitForExit()
$jfB64=[System.Convert]::ToBase64String($jarFile)
echo "Making js file..."
$jsResult=$jsFile.Replace("%mainDex%","")
echo "Downloading latest jar file..."
