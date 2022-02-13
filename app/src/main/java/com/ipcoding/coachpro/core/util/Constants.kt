package com.ipcoding.coachpro.core.util

object Constants {

    const val START_SEASON_WEEK = 26
    const val START_SEASON_YEAR = 2022
    const val START_TRANSFERS_TWO = 1
    const val END_TRANSFERS_TWO = 4
    const val START_MATCHES_TWO = 5
    const val END_MATCHES_TWO = 23
    const val SEASON_IS_OVER = 24
    const val CHANGE_HISTORY_AND_PLAYERS_YEAR = 23
    const val PREPARING_FOR_NEW_SEASON = 24
    const val PREPARATION_OF_CLUBS_AND_SCHEDULING  = 26
    const val START_TRANSFERS_ONE = 27
    const val END_TRANSFERS_ONE = 33
    const val START_MATCHES_ONE = 34
    const val END_MATCHES_ONE = 52

    val ALL_PLAYERS = arrayOf("Mbappe", "Neymar", "Mane", "Salah", "Kane", "De Bruyne",
        "Alexander-Arnold", "Sterling", "Felix", "Haaland", "Sancho", "Fernandes", "Gnabry",
        "Oblak", "Lukaku", "Son", "Kimmich", "Havertz", "Fati", "Davis", "Rashford", "van Dijk",
        "Alisson", "Messi", "de Ligt", "Robertson", "Courtois", "ter Stegen", "Firmino",
        "Martinez", "Valverde", "Oyarzabal", "Milinkovic-Savic", "Silva", "Dybala", "Sane",
        "Marquinhos", "Werner", "Varane", "Casemiro", "de Jong", "Gimenez", "Pogba", "Alaba",
        "Rodri", "Camavinga", "Foden", "Richarlison", "Jesus", "Upamecano", "Goretzka",
        "Donnarumma", "Pulisic", "Dias", "Fabinho", "Kante", "Laporte", "Niguez", "Griezmann",
        "Verratti", "Koulibaly", "Koke", "Lewandowski", "Ronaldo", "Ederson", "Rice", "Maddison",
        "Barella", "Coman", "Martial", "de Vrij", "Icardi", "Alaba", "Pedri", "Greenwood",
        "Kounde", "Osimhen", "Torres", "Hakimi", "Aouar", "Arthur", "Hernandez", "Carlos",
        "Chilwell", "Bastoni", "Dembele", "Llorente", "Tielemans", "Partey", "Neves", "Skriniar",
        "Grealish", "Zaha", "Morata", "Alberto", "Jorginho", "Coutinho", "Hazard", "Kroos",
        "Ruiz", "Chiesa", "Mahrez", "Insigne", "Thiago", "Bentancur", "Wirtz", "Ndombele",
        "Kulusevski", "Rodrygo", "Zaniolo", "Mount", "Calvert-Lewin", "Hernandez", "Ndidi",
        "Ziyech", "Ocampos", "Depay", "Immobile", "Kovacic", "Sabitzer", "Tapsoba", "Wan-Bissaka",
        "Lodi", "Saka", "Junior", "Bennacer", "Pepe", "Sanchez", "Jota", "Merino", "Zakaria",
        "Abraham", "Soyuncu", "Thuram", "Odegaard", "Keita", "Kessie", "Mendy", "van de Beek",
        "Kimpembe", "Correa", "Gomez", "Jimenez", "Traore", "Lenglet", "Zielinski", "Maguire",
        "Ake", "Belotti", "Ben Yedder", "Carvajal", "Walker", "Aubameyang", "Gundogan", "Wijnaldum",
        "Pjanic", "Reyna", "Diaby", "Lozano", "Olmo", "Neuhaus", "Alli", "Zapata", "Pellegrini",
        "Silva", "Sule", "Romagnoli", "Cancelo", "Brozovic", "Bellingham", "James", "Hudson-Odoi",
        "Bailey", "Soler", "Konate", "Pavard", "Lo Celso", "Asensio", "Angelino", "Locatelli",
        "de Paul", "Telles", "Semedo", "Gaya", "Guerreiro", "Zouma", "Calhanoglu", "Ginter",
        "Lacazette", "Rodriguez", "Eriksen", "Muller", "Szczesny", "Aguero", "Nkunku", "Digne",
        "Tonali", "Gomez", "Kamara", "Ceballos", "Saint-Maximin", "Pereira", "Klostermann",
        "Elvedi", "Rebic", "Thauvin", "Rabiot", "Dendoncker", "Kostic", "Manolas", "Hazard",
        "Matip", "Leno", "Kramaric", "David", "Cunha", "Neres", "Militao", "Kean", "Demiral",
        "Malen", "Watkins", "Vlasic", "Soucek", "Hermoso", "Simon", "Onana", "Dembele", "Weghorst",
        "Correa", "Brandt", "Bakayoko", "Haller", "Berardi", "Moreno", "Hojbjerg", "Plea",
        "Veretout", "Carrasco", "Corona", "Guimaraes", "Gravenberch", "Gabriel", "Milenkovic",
        "Barnes", "Leao", "Ikone", "Torreira", "Bowen", "Tierney"
    )

    val ALL_CLUBS = arrayOf("Bayern Munich", "FC Barcelona", "Juventus", "Real Madrid",
        "Atlético Madrid", "Manchester City", "Paris Saint-Germain", "Manchester United",
        "Liverpool", "Sevilla", "Arsenal", "Borussia Dortmund", "FC Porto", "Chelsea",
        "Tottenham Hotspur", "Shakhtar Donetsk", "AS Roma", "Olympique Lyon", "Ajax",
        "Napoli", "RB Leipzig", "FC Salzburg", "Benfica", "Bayer Leverkusen", "Internazionale",
        "Atalanta", "Zenit St. Petersburg", "FC Basel", "Besiktas", "Villarreal",
        "Sporting CP Lisbon", "Dinamo Kiev", "Lazio", "FC København", "Olympiakos Piraeus",
        "CSKA Moscow", "Valencia", "Dinamo Zagreb", "Slavia Praha", "AS Monaco", "Club Brugge",
        "Sporting Braga", "Schalke 04", "FK Krasnodar", "Celtic", "Viktoria Plzen",
        "Mönchengladbach", "Young Boys", "Eintracht Frankfurt", "Leicester City",
        "Red Star Belgrade", "Lokomotiv Moscow", "Racing Genk", "AC Milan", "Glasgow Rangers",
        "Olympique Marseille", "Ludogorets Razgrad", "APOEL Nicosia", "PSV Eindhoven", "Basaksehir",
        "AA Gent", "Anderlecht", "1899 Hoffenheim", "FK Astana", "Standard Liège", "AZ Alkmaar",
        "LASK", "Feyenoord", "Qarabag FK", "FCSB", "Maccabi Tel-Aviv", "PAOK Thessaloniki",
        "AEK Athens", "Fenerbahçe", "Stade Rennais", "Athletic Bilbao", "Celta de Vigo", "Malmö FF",
        "Spartak Moscow", "Partizan Belgrade", "Hapoel Beer-Sheva", "Sparta Praha", "BATE Borisov",
        "Rapid Wien", "Galatasaray", "CFR Cluj", "Legia Warsaw", "Zorya Luhansk", "VfL Wolfsburg",
        "Sheriff Tiraspol", "Lille OSC", "Rosenborg BK", "FK Rostov", "NK Maribor",
        "FC Midtjylland", "Ferencváros", "NK Rijeka", "Apollon Limassol", "Molde FK", "OGC Nice",
        "AS Saint-Étienne", "FC Zürich", "FC Fehérvár", "Wolfsberger AC", "Royal Antwerp",
        "Dundalk", "Austria Wien", "Östersunds FK", "Shkendija Tetovo", "FC Lugano", "AEK Larnaca",
        "Suduva Marijampole", "Slovan Liberec", "CSKA Sofia", "Zrinjski Mostar", "Hajduk Split",
        "F91 Dudelange", "Astra Giurgiu", "Osmanlispor", "Aberdeen", "Slovan Bratislava",
        "The New Saints", "Spartak Trnava", "FK Jablonec", "Brøndby IF", "Konyaspor",
        "Olimpija Ljubljana", "Dinamo Tbilisi", "Zalgiris Vilnius", "Alashkert FC", "FK Sarajevo",
        "Flora Tallinn", "Lech Poznan", "Buducnost Podgorica", "Kairat Almaty", "NK Osijek",
        "FK Kukësi", "Universitatea Craiova", "Valletta FC", "Dinamo Minsk"
    )

    const val GK = "GK"
    val DEF = arrayOf("DR", "DC", "DL", "DRC", "DRL", "DLC")
    val MID = arrayOf("MR", "MC", "ML", "MRC", "MRL", "MLC")
    val FOR = arrayOf("FR", "FC", "FL", "FRC", "FRL", "FLC")
    val ALL_POSITION = arrayOf(GK) + DEF + MID + FOR

    val T_541: List<Any> = listOf("5-4-1", 1, 5, 4, 1)
    val T_532: List<Any> = listOf("5-3-2", 1, 5, 3, 2)
    val T_451: List<Any> = listOf("4-5-1", 1, 4, 5, 1)
    val T_442: List<Any> = listOf("4-4-2", 1, 4, 4, 2)
    val T_433: List<Any> = listOf("4-3-3", 1, 4, 3, 3)
    val T_352: List<Any> = listOf("3-5-2", 1, 3, 5, 2)
    val T_343: List<Any> = listOf("3-4-3", 1, 3, 4, 3)

    val ALL_TACTICS: List<List<Any>> = listOf(T_541, T_532, T_451, T_442, T_433, T_352, T_343)
}