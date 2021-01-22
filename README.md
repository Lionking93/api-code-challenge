# api-code-challenge

[![Build Status](https://travis-ci.com/Lionking93/api-code-challenge.svg?token=7N8fiZrCRSxcKJvrxxAq&branch=master)](https://travis-ci.com/Lionking93/api-code-challenge)

Java Spring application that provides REST API that analyzes text.

API is available in following URL: https://leos-api-code-challenge.herokuapp.com/.

To use the API you should send a POST request to URL https://leos-api-code-challenge.herokuapp.com/analyze. Request body should be a JSON object in the following format:

```json
{
  "text":"heipodei 1234"
}
```

For this request, the API will return a following response:

```json
{
  "textLength":{"withSpaces":13,"withoutSpaces":12},
  "wordCount":2,
  "characterCount":[{"d":1},{"e":2},{"h":1},{"i":2},{"o":1},{"p":1}]
}
```
