public class Vokabeltest {
  
  public static void main(String[] args) {
  
    Vokabelkasten vk = new Vokabelkasten(3);
    
    vk.addVokabel(new Vokabel("Hund","dog"));
    vk.addVokabel(new Vokabel("Katze","cat"));
    vk.addVokabel(new Vokabel("Pferd","horse"));
    System.out.println(vk);
    
  }

}
