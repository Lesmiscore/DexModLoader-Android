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
java -classpath ./file.jar modules.build.BuildTask ./file2.jar ./file.jar ./lib/dx.jar
java -classpath ./file.jar modules.build.BuildTask ./file3.jar ./file2.jar ./lib/commons-compress-1.9.jar
java -classpath ./file.jar modules.build.BuildTask ./file2.jar ./file3.jar ./lib/commons-codec-1.10.jar
java -jar ./lib/dx.jar --dex --output=./dex.zip --multi-dex ./file2.jar
$jarFile=[system.io.file]::ReadAllBytes("./dex.zip")
$jfB64=[System.Convert]::ToBase64String($jarFile)
echo "Making js file..."
$jsResult=$jsFile.Replace("%mainDex%",$jfB64)
echo "Writing..."
[System.IO.File]::WriteAllText("./result.js",$jsResult)
echo "Deleting cache..."
[System.IO.File]::delete("./file.jar")
[System.IO.File]::delete("./file2.jar")
[System.IO.File]::delete("./file3.jar")
[System.IO.File]::delete("./dex.zip")
echo "Complete!"
echo "The file is result.js"
