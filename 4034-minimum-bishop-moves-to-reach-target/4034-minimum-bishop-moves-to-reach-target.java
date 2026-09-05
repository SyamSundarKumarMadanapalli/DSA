class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int scRow = source[0];
        int scCol = source[1];
        int tarRow = target[0];
        int tarCol = target[1];

        // if((scRow % 2 == 0 && scCol % 2 == 0) || (scRow % 2 != 0 && scCol % 2 != 0)){
        //     if((tarRow % 2 == 0 && tarCol % 2 == 0) || (tarRow % 2 != 0 && tarCol % 2 != 0)){
        //         if((tarRow + tarCol == scRow + scCol) || (tarRow - tarCol == scRow - scCol)) return 1;
        //         else return 2;
        //     }
        //     else return -1;
        // }
        // else{
        //     if((tarRow % 2 == 0 && tarCol % 2 == 0) || (tarRow % 2 != 0 && tarCol % 2 != 0)){
        //         return -1;
        //     }
        //     else{
        //         if((tarRow + tarCol == scRow + scCol) || (tarRow - tarCol == scRow - scCol)) return 1;
        //         else return 2;
        //     }
        // }

        if(scRow==tarRow && scCol==tarCol)return 0;
        if(Math.abs(scRow-tarRow)==Math.abs(scCol-tarCol)){
            return 1;
        }
        if((scRow+scCol)%2!=(tarRow+tarCol)%2){
            return -1;
        }
        return 2;
    }
}