class Solution {
public:
    int numberOfSubstrings(string s) {
        int a,b,c,cnt=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            a=b=c=0;
            for(int j=i;j<n;j++){
                if(s[j]=='a')a=1;
                else if(s[j]=='b')b=1;
                else c=1;

                if(a==1 && b==1 && c==1){
                    cnt+=n-j;
                    break;
                }
            }
        }
        return cnt;
    }
};