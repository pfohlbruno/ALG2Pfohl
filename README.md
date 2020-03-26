# ArrayOfPoints
## Zadání
Deklarace jednoduché třídy pro neměnitelné (konstantní objekty) a privátními atributy, konstruktorem
(respektive konstruktory) a metod pro čtení jednotlivých atributů. Vytvoření pole objektů tohoto typu
a jeho použití pro dané účely. Statické a dynamické pole objektů (tj. typy jako jsou: **Bod[]** a
**ArrayList\<Bod>**) – jejich vytvoření a použití.
### Úlohy
1. Vytvořte program, který uživateli umožní interaktivně zadávat vrcholy n-úhelníka a počítat jeho
obvod a plochu. Umožněte opakované řešení úlohy, komunikaci programu s uživatele realizujte
v podobě řádkového menu. Pro reprezentaci jediného bodu navrhněte a implementujte třídu Bod
(uchování souřadnic, inicializace objektů, poskytování hodnot souřadnic, vzdálenost bodu od počátku
a vzdálenost bodu od jiného bodu). Při výpočtu předpokládejte zadání bodů v pořadí, v jakém se
nachází na obvodu n-úhelníka.
Obvod spočteme jako součet délek všech stran.
Plochu *P* vypočtěte ze vztahu:

![alt text][formula]

2. Vytvořte program, který uživateli umožní interaktivně zadávat a zpracovávat sadu bodů. Body lze
přidávat najednou i poté přidávat jednotlivě. Program by měl umožňovat vyhledat bod s největší/
nejmenší vzdáleností do počátku, popřípadě dva body s maximální/minimální vzdáleností.
Komunikaci programu s uživatele realizujte formou řádkového menu. Pro reprezentaci jediného bodu
navrhněte a implementujte třídu *Bod* (uchování souřadnic, inicializace objektů, poskytování hodnot
souřadnic, vzdálenost bodu od počátku a vzdálenost bodu od jiného bodu).

[formula]: https://i.imgur.com/rK0IIIX.png "Spočtení obvodu"
