package com.ipcoding.coachpro.feature.domain.use_case

class GetClubsFromLeague {

    operator fun invoke(league: String?): Array<String> {
        var clubs: Array<String> = emptyArray()
        when(league) {
            "1" -> clubs = arrayOf("Bayern Munich", "FC Barcelona", "Juventus", "Real Madrid",
                "Atlético Madrid", "Manchester City", "Paris Saint-Germain", "Manchester United",
                "Liverpool", "Sevilla", "Arsenal", "Borussia Dortmund", "FC Porto", "Chelsea",
                "Tottenham Hotspur", "Shakhtar Donetsk", "AS Roma", "Olympique Lyon", "Ajax",
                "Napoli")
            "2" -> clubs = arrayOf("RB Leipzig", "FC Salzburg", "Benfica", "Bayer Leverkusen",
                "Internazionale", "Atalanta", "Zenit St. Petersburg", "FC Basel", "Besiktas",
                "Villarreal", "Sporting CP Lisbon", "Dinamo Kiev", "Lazio", "FC København",
                "Olympiakos Piraeus", "CSKA Moscow", "Valencia", "Dinamo Zagreb", "Slavia Praha",
                "AS Monaco")
            "3" -> clubs = arrayOf("Club Brugge", "Sporting Braga", "Schalke 04", "FK Krasnodar",
                "Celtic", "Viktoria Plzen", "Mönchengladbach", "Young Boys", "Eintracht Frankfurt",
                "Leicester City", "Red Star Belgrade", "Lokomotiv Moscow", "Racing Genk",
                "AC Milan", "Glasgow Rangers", "Olympique Marseille", "Ludogorets Razgrad",
                "APOEL Nicosia", "PSV Eindhoven", "Basaksehir")
            "4" -> clubs = arrayOf("AA Gent", "Anderlecht", "1899 Hoffenheim", "FK Astana",
                "Standard Liège", "AZ Alkmaar", "LASK", "Feyenoord", "Qarabag FK", "FCSB",
                "Maccabi Tel-Aviv", "PAOK Thessaloniki", "AEK Athens", "Fenerbahçe",
                "Stade Rennais", "Athletic Bilbao", "Celta de Vigo", "Malmö FF", "Spartak Moscow",
                "Partizan Belgrade")
            "5" -> clubs = arrayOf("Hapoel Beer-Sheva", "Sparta Praha", "BATE Borisov",
                "Rapid Wien", "Galatasaray", "CFR Cluj", "Legia Warsaw", "Zorya Luhansk",
                "VfL Wolfsburg", "Sheriff Tiraspol", "Lille OSC", "Rosenborg BK", "FK Rostov",
                "NK Maribor", "FC Midtjylland", "Ferencváros", "NK Rijeka", "Apollon Limassol",
                "Molde FK", "OGC Nice")
            "6" -> clubs = arrayOf("AS Saint-Étienne", "FC Zürich", "FC Fehérvár", "Wolfsberger AC",
                "Royal Antwerp", "Dundalk", "Austria Wien", "Östersunds FK", "Shkendija Tetovo",
                "FC Lugano", "AEK Larnaca", "Suduva Marijampole", "Slovan Liberec", "CSKA Sofia",
                "Zrinjski Mostar", "Hajduk Split", "F91 Dudelange", "Astra Giurgiu", "Osmanlispor",
                "Aberdeen")
            "7" -> clubs = arrayOf("Slovan Bratislava", "The New Saints", "Spartak Trnava",
                "FK Jablonec", "Brøndby IF", "Konyaspor", "Olimpija Ljubljana", "Dinamo Tbilisi",
                "Zalgiris Vilnius", "Alashkert FC", "FK Sarajevo", "Flora Tallinn", "Lech Poznan",
                "Buducnost Podgorica", "Kairat Almaty", "NK Osijek", "FK Kukësi",
                "Universitatea Craiova", "Valletta FC", "Dinamo Minsk")
        }
        return clubs
    }
}
