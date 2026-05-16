param(
    [string]$JdkPath
)

if (-not $JdkPath) {
    Write-Host "Uso: .\set-java-home.ps1 -JdkPath 'C:\\Program Files\\Java\\jdk-17.0.8'" -ForegroundColor Yellow
    exit 1
}

if (-not (Test-Path $JdkPath)) {
    Write-Host "Caminho informado não existe: $JdkPath" -ForegroundColor Red
    exit 1
}

# Definir JAVA_HOME para o usuário
[Environment]::SetEnvironmentVariable('JAVA_HOME', $JdkPath, 'User')
Write-Host "JAVA_HOME definido para: $JdkPath" -ForegroundColor Green

# Adicionar %JAVA_HOME%\bin ao PATH do usuário se não existir
$currentPath = [Environment]::GetEnvironmentVariable('Path','User')
$javaBin = Join-Path $JdkPath 'bin'
if ($currentPath -notlike "*${javaBin}*") {
    $newPath = $currentPath + ';' + $javaBin
    [Environment]::SetEnvironmentVariable('Path', $newPath, 'User')
    Write-Host "Adicionado $javaBin ao Path do usuário." -ForegroundColor Green
} else {
    Write-Host "$javaBin já presente no Path do usuário." -ForegroundColor Cyan
}

Write-Host "Feche e reabra o terminal para que as alterações tenham efeito." -ForegroundColor Yellow
