class Solution {
public:
    int findSetBits(int n){
        int cnt=0;
        while(n>0){
            if(n & 1 == 1)cnt++;
            n = n>>1;
        }
        return cnt;
    }


    vector<string> readBinaryWatch(int turnedOn) {
        vector<string>ans;
        for(int i=0; i< 12; i++){
            for(int j=0; j< 60; j++){
                if(findSetBits(i) + findSetBits(j) == turnedOn){
                    string time = to_string(i) + ":" + ((j<10) ? "0" : "") + to_string(j); 
                    ans.push_back(time);
                }
            }
        }
        return ans;
    }
};

