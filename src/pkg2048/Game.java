package pkg2048;
import java.util.ArrayList;
import java.util.Random;
public class Game {
private int[][] lentele;
private Random r = new Random();
private Busena state;
private int score;
public Game() {
lentele = new int [4][4];
pridetiSkaiciu();
pridetiSkaiciu();
state = Busena.CONTINUE;
}

public int[][] getlentele() {
    return lentele;
}
public Busena getState() {
  return state;
}
public int getScore() {
  return score;  
}
public void masyvas() {
for (int[] x: lentele) {
System.out.format("%6d%6d%6d%6d%n", x[0], x[1], x[2], x[3]);
}
System.out.format("%n");
}
public void pridetiSkaiciu() {
    if (checkBoardFull()) {
        return;
    }
    ArrayList<Integer> tustiLangX = new ArrayList<Integer>();
    ArrayList<Integer> tustiLangY = new ArrayList<Integer>();
    for (int x = 0; x < 4; x++){
        for (int y = 0; y < 4; y++) {
            if (lentele[x][y] == 0){
                tustiLangX.add(new Integer(x));
                tustiLangY.add(new Integer(y));
        }
    }
}
    int choice = r.nextInt(tustiLangX.size());
    int randomSk = r.nextInt(10); //0-9
    int naujasSk = 2;
    if (randomSk == 0) {
        naujasSk = 4;
    }
    int X = tustiLangX.get(choice);
    int Y= tustiLangY.get(choice);
    lentele[X][Y] = naujasSk;
}
public void Aukstyn() {
    System.out.println("I virsu");
    for (int y = 0; y < 4; y++) {
        boolean[] jauSujungta = {false, false, false, false};
        for (int x = 1; x < 4; x++) {
            if(lentele[x][y] != 0) {
                int value = lentele[x][y];
                int X = x - 1;
                while((X >= 0) && (lentele[X][y] == 0)) {
                X--;
            }
                if (X == -1) {
                    lentele[0][y] = value;
                    lentele[x][y] = 0;
                }
                else if (lentele[X][y] != value) {
                    lentele[x][y] = 0;
                    lentele[X+1][y] = value;
                
                }
                else {
                    if (jauSujungta[X]) {
                        lentele[x][y] = 0;
                    lentele[X+1][y] = value;
                    }
                    else {
                        lentele[x][y] = 0;
                        lentele[X][y] *=2;
                        score += lentele[X][y];
                        jauSujungta[X] = true;
                    }
                }
        }
    }
        
}
}
public void Zemyn() {
    System.out.println("I apacia");
    for (int y = 0; y < 4; y++) {
        boolean[] jauSujungta = {false, false, false, false};
        for (int x = 2; x > -1; x--) {
            if(lentele[x][y] != 0) {
                int value = lentele[x][y];
                int X = x + 1;
                while((X <= 3) && (lentele[X][y] == 0)) {
                X ++;
            }
                if (X == 4) {
                    lentele[3][y] = value;
                    lentele[x][y] = 0;
                }
                else if (lentele[X][y] != value) {
                    lentele[x][y] = 0;
                    lentele[X-1][y] = value;
                }
                else {
                    if (jauSujungta[X]) {
                    lentele[x][y] = 0;
                    lentele[X-1][y] = value;
                    }
                    else { //sujungiam 2 numerius
                        lentele[x][y] = 0;
                        lentele[X][y] *=2;
                        score += lentele[X][y];
                        jauSujungta[X] = true;
                        //lentele[x][y] = 0;
                }
        }
    }
}
}
}
public void Kaire() {
    System.out.println("I kaire");
    for (int x = 0; x < 4; x++) {
        boolean[] jauSujungta = {false, false, false, false};
        for (int y = 1; y < 4; y++) {
            if(lentele[x][y] != 0) {
                int value = lentele[x][y];
                int Y = y - 1;
                while((Y >= 0) && (lentele[x][Y] == 0)) {
                Y--;
            }
                if (Y == -1) {
                    lentele[x][0] = value;
                    lentele[x][y] = 0;
                }
                else if (lentele[x][Y] != value) {
                    lentele[x][y] = 0;
                    lentele[x][Y+1] = value;
                }
                else {
                    if (jauSujungta[Y]) {
                    lentele[x][y] = 0;
                    lentele[x][Y+1] = value;
                    }
                    else {
                        lentele[x][y] = 0;
                        lentele[x][Y] *=2;
                        score += lentele[x][Y];
                        jauSujungta[Y] = true;
                }
        }
    }
}
}
}
public void Desine() {
    System.out.println("Desine");
    for (int x = 0; x < 4; x++) {
        boolean[] jauSujungta = {false, false, false, false};
        for (int y = 2; y > -1; y--) {
            if(lentele[x][y] != 0) {
                int value = lentele[x][y];
                int Y = y + 1;
                while((Y <= 3) && (lentele[x][Y] == 0)) {
                Y++;
            }
                if (Y == 4) {
                    lentele[x][3] = value;
                    lentele[x][y] = 0;
                }
                else if (lentele[x][Y] != value) {
                    lentele[x][y] = 0;
                    lentele[x][Y-1] = value;
                }
                else {
                    if (jauSujungta[Y]) {
                    lentele[x][y] = 0;
                    lentele[x][Y-1] = value;
                    
                    }
                    else {
                        lentele[x][y] = 0;
                        lentele[x][Y] *=2;
                        score += lentele[x][Y];
                        jauSujungta[Y] = true;
}
                }}}}

}
// true jei pasiekiamas 2048
public boolean checkFor2048(){
for (int x = 0; x < 4; x++){
    for (int y = 0; y < 4; y++){
        if (lentele[x][y] == 2048) {
            return true;
        }
    }
}
return false;
}
// true jei nebera ejimu
public boolean checkBoardFull() {
    for (int x = 0; x < 4; x++){
    for (int y = 0; y < 4; y++){
        if (lentele[x][y] == 0) {
            return false;
        }
}
    }
        return true;
}
// true jei salia yra tinkantys sujungt skaiciai
public boolean arYraEjimu(){
    for (int x = 0; x < 4; x++) { 
        for (int y = 0; y < 4; y++){
            if (x==0){
                if(y!=0) {
                    if(lentele[x][y] == lentele[x][y-1]) {
                        return true;
                    }
                }
            } else {
                if(y!=0) {
                    if(lentele[x][y] == lentele[x][y-1]) {
                        return true;
            }
        } 
                if(lentele[x][y] == lentele[x-1][y]) {
                    return true;
                }
            }}
    }
            return false;
}
public void checkState(){
   // patikrinti Busena
   if (checkFor2048()) {
       state = Busena.WIN;
   } else if (checkBoardFull()){
       if(arYraEjimu()) {
           state = Busena.CONTINUE;
       } else{
           state = Busena.LOSE;
       }
       } else {
   state = Busena.CONTINUE;
   }
}
}

  

    
