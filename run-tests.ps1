param()

Write-Host "Validando JAVA_HOME..."
$javaHome = [Environment]::GetEnvironmentVariable('JAVA_HOME','User')
if (-not $javaHome) {
    $javaHome = [Environment]::GetEnvironmentVariable('JAVA_HOME','Machine')
}

if (-not $javaHome) {
    Write-Host "ERROR: JAVA_HOME não está definido. Defina JAVA_HOME apontando para um JDK (ex.: C:\\Program Files\\Java\\jdk-17.x)." -ForegroundColor Red
    exit 1
}

Write-Host "JAVA_HOME detectado em: $javaHome"
Write-Host "Versão do java:"
& "$javaHome\bin\java.exe" -version

Write-Host "Executando testes com Maven Wrapper..."
& .\mvnw.cmd test
