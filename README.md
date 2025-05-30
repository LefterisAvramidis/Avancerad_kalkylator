# Avancerad_kalkylator

Detta är ett JavaFX-baserat kalkylatorprojekt byggt som ett examensarbete av Lefteris Avramidis.

## Funktioner
- Grundläggande räknesätt (+, −, ×, ÷)
- Procent, kvadratrötter och upphöjt
- Historikpanel och tema (ljust/mörkt)
- Stöd för uttryck som `(2+3)*4` via exp4j

## Starta projektet
1. Placera `exp4j-0.4.8.jar` i mappen `lib/`
2. Ha JavaFX SDK installerad
3. Kompilera:
   ```bash
   javac -cp ".:lib/exp4j-0.4.8.jar" \
   --module-path /sökväg/till/javafx-sdk/lib \
   --add-modules javafx.controls,javafx.fxml \
   Main.java controller/*.java model/*.java view/*.java utils/*.java

## KÖR PROJEKTET 
```bash
java -cp ".:lib/exp4j-0.4.8.jar" \
--module-path /sökväg/till/javafx-sdk/lib \
--add-modules javafx.controls,javafx.fxml \
Main
