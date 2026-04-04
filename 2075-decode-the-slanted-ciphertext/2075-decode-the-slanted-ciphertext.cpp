class Solution {
public:
    string decodeCiphertext(string encodedText, int rows) {
        int cols = encodedText.length() / rows;
        string original = "";

        for (int i = 0; i < cols; i++) {
            for(int j = i; j< encodedText.length(); j+=(cols+1)){
                original += encodedText[j];
            }
        }

        while(!original.empty() && original.back() == ' '){
            original.pop_back();
        }

        return original;
    }
};