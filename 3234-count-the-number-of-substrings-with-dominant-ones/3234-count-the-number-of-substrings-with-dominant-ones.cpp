class Solution {
public:
    int numberOfSubstrings(string s) {
        int n = s.length();
        vector<int>onesCount(n,0);
        onesCount[0]= (s[0]== '1') ? 1:0;
        for(int i=1;i<n;i++){
            onesCount[i]=onesCount[i-1] + ((s[i]=='1') ? 1 :0);
        }
        
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int ones = onesCount[j] - ((i>0)? onesCount[i-1] : 0);
                int zeroes = (j-i+1)-ones;

                if((zeroes*zeroes) > ones){
                    int nxt=(zeroes*zeroes) - ones;
                    j +=nxt-1;
                }else if((zeroes*zeroes) == ones){
                    result++;
                }else{
                    result++;
                    int k = sqrt(ones)-zeroes;
                    int next=j+k;
                    if(next >= n){
                        result += (n-j-1);
                        break;
                    }else{
                        result+=k;
                    }
                    j=next;
                }
            }
        }
        return result;
    }
};