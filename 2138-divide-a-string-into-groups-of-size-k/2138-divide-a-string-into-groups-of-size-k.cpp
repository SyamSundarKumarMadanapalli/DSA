class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
        vector<string>ans;
        int n=s.size();
        for(int i=0;i<n;i+=k){
            if(i+k<=n){
                ans.push_back(s.substr(i,k));
            }
        }
        int rem=n%k;
        string str="";
        if(rem!=0){
            str=s.substr(n-rem);
            while(k-rem!=0){
                str=str+fill;
                rem++;
            }
            ans.push_back(str);
        }
        
        return ans;
    }
};