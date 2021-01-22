# api-code-challenge

[![Build Status](https://travis-ci.com/Lionking93/api-code-challenge.svg?token=7N8fiZrCRSxcKJvrxxAq&branch=master)](https://travis-ci.com/Lionking93/api-code-challenge)

Java Spring application that provides REST API that analyzes text.

API is available in following URL: https://leos-api-code-challenge.herokuapp.com/.

To use the API you should send a POST request to URL https://leos-api-code-challenge.herokuapp.com/analyze. Request body should be a JSON object in the following format:

```json
{
  "text":"hello 2 times  "
}
```

For this request, the API will return a following response:

```json
{
  "textLength":{"withSpaces":15,"withoutSpaces":11},
  "wordCount":3,
  "characterCount":[{"e":2},{"h":1},{"i":1},{"l":2},{"m":1},{"o":1},{"s":1},{"t":1}]
}
```
