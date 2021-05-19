package main

import (
	"log"
	"net/http"
)

func main() {
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		w.Write([]byte("下班了没？"))
	})
	log.Fatal(http.ListenAndServe(":80", nil))
}
