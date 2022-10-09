public class Books {
    private String bookList[] = {
        /*0 */    "Sofies Welt",
        /*1 */    "Das Grosze Woerterbuch der deutschen Sprache",
        /*2 */    "Die KacurrentPlayer.getEnguru Chroniken",
        /*3 */    "Lexikon der Biologie",
        /*4 */    "Ups and Downs - Einfuehrung in Quantenphysik",
        /*5 */    "Algebra 1",
        /*6 */    "Kritik der reinen Vernunft",
        /*7 */    "Was ist sein? Was ist nicht sein?",
        /*8 */    "Gott ist tot",
        /*9 */    "Die Bibel",
        /*10 */   "Romeo und Julia",
        /*11 */   "Emile oder ueber die Erziehung",
        /*12 */   "Also sprach Zarathustra",
        /*13 */   "Das grosze Buch der Witze",
        /*14 */   "Nichts, rein gar nichts: Das Buch fuer alle, die sich nichts wuenschen",
        /*15 */   "Algebra 2",
        /*16 */   "Faith and Misery",
        /*17 */   "With the lights out, its less dancurrentPlayer.getGerous",
        /*18 */   "Leave it alone, Find a home, Go back home",
        /*19 */   "I did it my way"
        };

    public String getBookNameByID(int id) {
        return bookList[id];
    }

    public String printOptions() {
        int [] pick = new int[4];
        String bookOpt = "";
        double rndm = 0;
        for (int i = 1; i<4; i++) {
            do {
                rndm = Math.random() * 20;
            } while((int) rndm == pick[1] || (int) rndm == pick[2]);  //! CHECK FOR DOUBLED BOOKS
            pick[i] = (int) rndm;

            System.out.println("[" + i + "] " + getBookNameByID((int) (rndm)));
        }
        return bookOpt;
    }
}