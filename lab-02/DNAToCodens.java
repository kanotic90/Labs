import java.util.ArrayList;
import java.util.HashMap;

public class DNAToCodens {

    public static void main(String[] args) {
        String DNA1 = "CTGATATTGTATCCGGCCGAA";
        String DNA2 = "CTAGCCGGTGGTTATTAATAGTAAACTATTCCA";
        String DNA3 = "TTAATCCTCTACCCCGCAGAG";

        String amino1 = dna_to_amino_acid(DNA1);
        String amino2 = dna_to_amino_acid(DNA2);
        String amino3 = dna_to_amino_acid(DNA3);

        System.out.println("DNA1 amino acids: " + amino1);
        System.out.println("DNA2 amino acids: " + amino2);
        System.out.println("DNA3 amino acids: " + amino3);

        System.out.println("\nComparisons:");
        System.out.println("DNA1 vs DNA2: " + amino1.equals(amino2));
        System.out.println("DNA1 vs DNA3: " + amino1.equals(amino3));
        System.out.println("DNA2 vs DNA3: " + amino2.equals(amino3));
    }

    public static ArrayList<String> convertDNAToCodens(String dna) {
        ArrayList<String> codons = new ArrayList<String>();

        for (int i = 0; i + 3 <= dna.length(); i += 3) {
            String codon = dna.substring(i, i + 3);
            codons.add(codon);
        }

        return codons;
    }

    public static String dna_to_amino_acid(String dna) {
        ArrayList<String> codons = convertDNAToCodens(dna);
        StringBuilder aminoAcids = new StringBuilder();

        for (String codon : codons) {
            aminoAcids.append(CodonToAminoAcid(codon));
        }

        return aminoAcids.toString();
    }

    public static boolean is_match(ArrayList<String> seq1, ArrayList<String> seq2) {
        if (seq1.size() != seq2.size()) {
            return false;
        }

        for (int i = 0; i < seq1.size(); i++) {
            if (!seq1.get(i).equals(seq2.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static String CodonToAminoAcid(String codon) {
        HashMap<String, String> codonMap = new HashMap<String, String>();

        codonMap.put("TTT", "F");
        codonMap.put("TTC", "F");
        codonMap.put("TTA", "L");
        codonMap.put("TTG", "L");
        codonMap.put("CTT", "L");
        codonMap.put("CTC", "L");
        codonMap.put("CTA", "L");
        codonMap.put("CTG", "L");
        codonMap.put("ATT", "I");
        codonMap.put("ATC", "I");
        codonMap.put("ATA", "I");
        codonMap.put("ATG", "M");
        codonMap.put("GTT", "V");
        codonMap.put("GTC", "V");
        codonMap.put("GTA", "V");
        codonMap.put("GTG", "V");
        codonMap.put("TCT", "S");
        codonMap.put("TCC", "S");
        codonMap.put("TCA", "S");
        codonMap.put("TCG", "S");
        codonMap.put("AGT", "S");
        codonMap.put("AGC", "S");
        codonMap.put("CCT", "P");
        codonMap.put("CCC", "P");
        codonMap.put("CCA", "P");
        codonMap.put("CCG", "P");
        codonMap.put("ACT", "T");
        codonMap.put("ACC", "T");
        codonMap.put("ACA", "T");
        codonMap.put("ACG", "T");
        codonMap.put("GCT", "A");
        codonMap.put("GCC", "A");
        codonMap.put("GCA", "A");
        codonMap.put("GCG", "A");
        codonMap.put("TAT", "Y");
        codonMap.put("TAC", "Y");
        codonMap.put("TAA", "*");
        codonMap.put("TAG", "*");
        codonMap.put("TGA", "*");
        codonMap.put("CAT", "H");
        codonMap.put("CAC", "H");
        codonMap.put("CAA", "Q");
        codonMap.put("CAG", "Q");
        codonMap.put("AAT", "N");
        codonMap.put("AAC", "N");
        codonMap.put("AAA", "K");
        codonMap.put("AAG", "K");
        codonMap.put("GAT", "D");
        codonMap.put("GAC", "D");
        codonMap.put("GAA", "E");
        codonMap.put("GAG", "E");
        codonMap.put("TGT", "C");
        codonMap.put("TGC", "C");
        codonMap.put("TGG", "W");
        codonMap.put("CGT", "R");
        codonMap.put("CGC", "R");
        codonMap.put("CGA", "R");
        codonMap.put("CGG", "R");
        codonMap.put("AGA", "R");
        codonMap.put("AGG", "R");
        codonMap.put("GGT", "G");
        codonMap.put("GGC", "G");
        codonMap.put("GGA", "G");
        codonMap.put("GGG", "G");

        return codonMap.get(codon);
    }
}