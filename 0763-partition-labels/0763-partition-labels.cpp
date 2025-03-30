class Solution {
public:
    vector<int> partitionLabels(string s) {
        vector<int>v(26,-1),ans;
        int n=s.length();
        for(int i=0;i<n;i++){
            v[s[i]-'a']=i;
        }
        int i=0;
        int st=0;
        int grind=v[s[0]-'a'];
        if(grind==n-1)return {n};
        while(i<n){
            if(v[s[i]-'a'] >grind){
                grind=v[s[i]-'a'];
            }
            if(i==grind){
                ans.push_back(i-st+1);
                st=i+1;
            }
            i++;
        }
        return ans;
    }
};