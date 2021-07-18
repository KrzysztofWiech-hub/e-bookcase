# e-bookcase
E-bookcase allowing create, read, update and delete quotes of authors. 

Aplikacja e-bookcase posiada dwa profile Spring'a, aktualnie profil ustawiony jest na dev w pliku application.properties (odpali się na bazie H2). 
Aby odpalić aplikację: 
1. Zaimportować ją jako projekt maven.
2. Ustawić profil Springa w application.properties najlepiej na dev (aplikacja wstanie na bazie H2)
3. Uruchomić aplikację (klasa startowa EBookcaseApplication.java)

E-bookcase posiada dwie klasy kontrolerów dla cytatu oraz autora - AuthorController.java oraz QuoteController.java
Aby dodać cytaty należy pierw dodać autora. 

# AuthorController.java

1. Pobiera wszystkich autorów oraz ich cytaty
@GetMapping(value = "/author/quote")

2. Tworzy autora
@PostMapping("/author")


# QuoteController.java

1. Dodaje cytat do wybranego autora
@PostMapping(value = "/quote/author")

2. Pobiera wszytkie istniejące cytaty
@GetMapping(value = "/quote/author")

3. Aktualizuje wybrany cytat
@PutMapping(value = "/quote/id/{quoteId}")

4. Usuwa wybrany cytat
@DeleteMapping(value = "/quote/id/{quoteId}")
