package sentenceGenerator;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
		
	Adverbs adverbs;
	Nouns nouns;
	Verbs verbs;
	
	public static void main(String[] args) {
		Adverbs adverb = Adverbs.values()[ThreadLocalRandom.current().nextInt(0, Adverbs.values().length)];
		Nouns noun = Nouns.values()[ThreadLocalRandom.current().nextInt(0, Nouns.values().length)];
		Verbs verb = Verbs.values()[ThreadLocalRandom.current().nextInt(0, Verbs.values().length)];
		
		String sentence = noun.toString() +" "+ adverb.toString() + " "+verb.toString();
		System.out.println(sentence);
		
	}

}

