class Solution {
public:
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        vector<int>count;
        vector<int>ans;
        int cnt=0;
        for(auto word:words){
            int n=word.length()-1;
            if((word[0]=='a' || word[0]=='e' || word[0]=='i' || word[0]=='o' || word[0]=='u') &&(word[n]=='a' || word[n]=='e' || word[n]=='i' || word[n]=='o' || word[n]=='u')){
                cnt=cnt+1;
            }
            count.push_back(cnt);
        }

        int sum=0;
        for(auto it:queries){
            if(it[0]!=0){
                sum=count[it[1]]-count[it[0]-1];
            }else{
                sum=count[it[1]];
            }
            ans.push_back(sum);
        }
        return ans;
    }
};