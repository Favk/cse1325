import java.util.Scanner;

public class Quint {

	public class Word{
		private char[5] letters;

		public void Word(String word){
			for(int i = 0; i < 5; i++)
				letters[i] = word.charAt(i);
		}

		public char charAt(int position){
			return letters[position];
		}

		public void setCharAt(char c, int position){
			letters[position] = c;
		} 

		public String toString(){
			String array = new String(letters);
			return array;
		}
	}

	public class Puzzle{
		private Word solution;
		private boolean solved;

		public void Puzzle(String solution){

		}

		private boolean isSolved(){

		}
	}


	public class WordList{
	    public static String getWord() {
	        return words[(int) (words.length * Math.random())];
	    }
	    private final static String[] words = new String[]{     "CIGAR",  "REBUT",  "SISSY",  "HUMPH",  "AWAKE",  "BLUSH",  "FOCAL",  "EVADE",  "NAVAL",  "SERVE",  "HEATH",  "DWARF",  "MODEL",  "KARMA",  "STINK",  "GRADE",  "QUIET",  "BENCH",  "ABATE",  "FEIGN",  "MAJOR",  "DEATH",  "FRESH",  "CRUST",  "STOOL",  "COLON",  "ABASE",  "MARRY",  "REACT",  "BATTY",  "PRIDE",  "FLOSS",  "HELIX",  "CROAK",  "STAFF",  "PAPER",  "UNFED",  "WHELP",  "TRAWL",  "OUTDO",  "ADOBE",  "CRAZY",  "SOWER",  "REPAY",  "DIGIT",  "CRATE",  "CLUCK",  "SPIKE",  "MIMIC",  "POUND",  "MAXIM",  "LINEN",  "UNMET",  "FLESH",  "BOOBY",  "FORTH",  "FIRST",  "STAND",  "BELLY",  "IVORY",  "SEEDY",  "PRINT",  "YEARN",  "DRAIN",  "BRIBE",  "STOUT",  "PANEL",  "CRASS",  "FLUME",  "OFFAL",  "AGREE",  "ERROR",  "SWIRL",  "ARGUE",  "BLEED",  "DELTA",  "FLICK",  "TOTEM",  "WOOER",  "FRONT",  "SHRUB",  "PARRY",  "BIOME",  "LAPEL",  "START",  "GREET",  "GONER",  "GOLEM",  "LUSTY",  "LOOPY",  "ROUND",  "AUDIT",  "LYING",  "GAMMA",  "LABOR",  "ISLET",  "CIVIC",  "FORGE",  "CORNY",  "MOULT",  "BASIC",  "SALAD",  "AGATE",  "SPICY",  "SPRAY",  "ESSAY",  "FJORD",  "SPEND",  "KEBAB",  "GUILD",  "ABACK",  "MOTOR",  "ALONE",  "HATCH",  "HYPER",  "THUMB",  "DOWRY",  "OUGHT",  "BELCH",  "DUTCH",  "PILOT",  "TWEED",  "COMET",  "JAUNT",  "ENEMA",  "STEED",  "ABYSS",  "GROWL",  "FLING",  "DOZEN",  "BOOZY",  "ERODE",  "WORLD",  "GOUGE",  "CLICK",  "BRIAR",  "GREAT",  "ALTAR",  "PULPY",  "BLURT",  "COAST",  "DUCHY",  "GROIN",  "FIXER",  "GROUP",  "ROGUE",  "BADLY",  "SMART",  "PITHY",  "GAUDY",  "CHILL",  "HERON",  "VODKA",  "FINER",  "SURER",  "RADIO",  "ROUGE",  "PERCH",  "RETCH",  "WROTE",  "CLOCK",  "TILDE",  "STORE",  "PROVE",  "BRING",  "SOLVE",  "CHEAT",  "GRIME",  "EXULT",  "USHER",  "EPOCH",  "TRIAD",  "BREAK",  "RHINO",  "VIRAL",  "CONIC",  "MASSE",  "SONIC",  "VITAL",  "TRACE",  "USING",  "PEACH",  "CHAMP",  "BATON",  "BRAKE",  "PLUCK",  "CRAZE",  "GRIPE",  "WEARY",  "PICKY",  "ACUTE",  "FERRY",  "ASIDE",  "TAPIR",  "TROLL",  "UNIFY",  "REBUS",  "BOOST",  "TRUSS",  "SIEGE",  "TIGER",  "BANAL",  "SLUMP",  "CRANK",  "GORGE",  "QUERY",  "DRINK",  "FAVOR",  "ABBEY",  "TANGY",  "PANIC",  "SOLAR",  "SHIRE",  "PROXY",  "POINT",  "ROBOT",  "PRICK",  "WINCE",  "CRIMP",  "KNOLL",  "SUGAR",  "WHACK",  "MOUNT",  "PERKY",  "COULD",  "WRUNG",  "LIGHT",  "THOSE",  "MOIST",  "SHARD",  "PLEAT",  "ALOFT",  "SKILL",  "ELDER",  "FRAME",  "HUMOR",  "PAUSE",  "ULCER",  "ULTRA",  "ROBIN",  "CYNIC",  "AGORA",  "AROMA",  "CAULK",  "SHAKE",  "PUPAL",  "DODGE",  "SWILL",  "TACIT",  "OTHER",  "THORN",  "TROVE",  "BLOKE",  "VIVID",  "SPILL",  "CHANT",  "CHOKE",  "RUPEE",  "NASTY",  "MOURN",  "AHEAD",  "BRINE",  "CLOTH",  "HOARD",  "SWEET",  "MONTH",  "LAPSE",  "WATCH",  "TODAY",  "FOCUS",  "SMELT",  "TEASE",  "CATER",  "MOVIE",  "LYNCH",  "SAUTE",  "ALLOW",  "RENEW",  "THEIR",  "SLOSH",  "PURGE",  "CHEST",  "DEPOT",  "EPOXY",  "NYMPH",  "FOUND",  "SHALL",  "HARRY",  "STOVE",  "LOWLY",  "SNOUT",  "TROPE",  "FEWER",  "SHAWL",  "NATAL",  "FIBRE",  "COMMA",  "FORAY",  "SCARE",  "STAIR",  "BLACK",  "SQUAD",  "ROYAL",  "CHUNK",  "MINCE",  "SLAVE",  "SHAME",  "CHEEK",  "AMPLE",  "FLAIR",  "FOYER",  "CARGO",  "OXIDE",  "PLANT",  "OLIVE",  "INERT",  "ASKEW",  "HEIST",  "SHOWN",  "ZESTY",  "HASTY",  "TRASH",  "FELLA",  "LARVA",  "FORGO",  "STORY",  "HAIRY",  "TRAIN",  "HOMER",  "BADGE",  "MIDST",  "CANNY",  "FETUS",  "BUTCH",  "FARCE",  "SLUNG",  "TIPSY",  "METAL",  "YIELD",  "DELVE",  "BEING",  "SCOUR",  "GLASS",  "GAMER",  "SCRAP",  "MONEY",  "HINGE",  "ALBUM",  "VOUCH",  "ASSET",  "TIARA",  "CREPT",  "BAYOU",  "ATOLL",  "MANOR",  "CREAK",  "SHOWY",  "PHASE",  "FROTH",  "DEPTH",  "GLOOM",  "FLOOD",  "TRAIT",  "GIRTH",  "PIETY",  "PAYER",  "GOOSE",  "FLOAT",  "DONOR",  "ATONE",  "PRIMO",  "APRON",  "BLOWN",  "CACAO",  "LOSER",  "INPUT",  "GLOAT",  "AWFUL",  "BRINK",  "SMITE",  "BEADY",  "RUSTY",  "RETRO",  "DROLL",  "GAWKY",  "HUTCH",  "PINTO",  "GAILY",  "EGRET",  "LILAC",  "SEVER",  "FIELD",  "FLUFF",  "HYDRO",  "FLACK",  "AGAPE",  "WENCH",  "VOICE",  "STEAD",  "STALK",  "BERTH",  "MADAM",  "NIGHT",  "BLAND",  "LIVER",  "WEDGE",  "AUGUR",  "ROOMY",  "WACKY",  "FLOCK",  "ANGRY",  "BOBBY",  "TRITE",  "APHID",  "TRYST",  "MIDGE",  "POWER",  "ELOPE",  "CINCH",  "MOTTO",  "STOMP",  "UPSET",  "BLUFF",  "CRAMP",  "QUART",  "COYLY",  "YOUTH",  "RHYME",  "BUGGY",  "ALIEN",  "SMEAR",  "UNFIT",  "PATTY",  "CLING",  "GLEAN",  "LABEL",  "HUNKY",  "KHAKI",  "POKER",  "GRUEL",  "TWICE"};
	}


	public static void main(String[] args) {
		
	}
}