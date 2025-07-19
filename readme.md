# 🎯 Subtitle Generator API

API REST em **Kotlin com Spring Boot** que gera **legendas otimizadas para redes sociais** (Instagram, Twitter, LinkedIn) com base em imagens e parâmetros personalizados como **tom** (engraçado, informativo, inspirador, etc.), utilizando a inteligência artificial da **Gemini 1.5 (Google)**.

---

## 🚀 Funcionalidades

- Upload de imagem (JPEG/PNG)
- Escolha de tom (engraçado, inspirador, informativo, etc.)
- Escolha de plataforma (Instagram, Twitter, LinkedIn)
- Geração de legenda criativa e pronta para postagem
- Hashtags separadas no final
- Integração com Google Gemini API (`gemini-1.5-flash`)

---

## ⚙️ Tecnologias Utilizadas

- Kotlin
- Spring Boot
- Maven
- WebClient
- Gemini (Google AI)
- Multipart upload

---

## 📦 Como executar o projeto localmente

### 1. Clone o repositório

```bash
git clone https://github.com/seuusuario/subititlegenerator.git
cd subititlegenerator
```

### 2. Configure a chave da API Gemini

Você precisa de uma chave de API do Google AI Studio (Gemini):

1. Acesse [makersuite.google.com](https://makersuite.google.com)
2. Clique em **"Get API Key"** no menu lateral
3. Copie a chave e configure no seu ambiente:

**Linux/macOS:**

```bash
export GEMINI_API_KEY="sua_chave_aqui"
```

**Windows (CMD):**

```cmd
set GEMINI_API_KEY=sua_chave_aqui
```

**Windows (PowerShell):**

```powershell
$env:GEMINI_API_KEY="sua_chave_aqui"
```

### 3. Execute a aplicação

```bash
./mvnw spring-boot:run
```

A API estará disponível em:  
📍 `http://localhost:8080/caption`

---

## 📤 Endpoint de Geração de Legenda

### `POST /caption`

**Content-Type:** `multipart/form-data`

#### Parâmetros do formulário:

- `image` (MultipartFile): Arquivo da imagem (.jpg ou .png)
- `tone` (String): Tom da legenda (`FUNNY, INFORMATIVE, INSPIRATIONAL, CASUAL, PROFESSIONAL`, etc.)
- `platform` (String): Plataforma alvo (`INSTAGRAM`, `TWITTER`, `LINKEDIN`)

> Os valores devem seguir os enums `ToneEnum` e `PlatformEnum`.

---

### ✅ Exemplo com `curl`:

```bash
curl -X POST http://localhost:8080/caption   -F image=@imagem.jpg   -F tone=ENGRACADO   -F platform=INSTAGRAM
```

---

### ✅ Exemplo de resposta:

```json
{
  "caption": "Arrasando nos céus com meu look camuflado! 😎🦜\n#papagaiostyle #camuflagem #birdlover #natureza"
}
```

---

## 🛠️ application.yml

```yaml
spring:
  application:
    name: subititlegenerator

gemini:
  api:
    key: ${GEMINI_API_KEY}
    url: https://generativelanguage.googleapis.com/v1/models/gemini-1.5-flash:generateContent
```

---

## ✨ Autor

Desenvolvido por [Igor Bavand](https://github.com/igorbavand)