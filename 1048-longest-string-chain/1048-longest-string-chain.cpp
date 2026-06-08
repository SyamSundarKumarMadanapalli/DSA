class Solution {
public:
    unordered_set<string> st;
    unordered_map<string, int> memo;

    int dfs(string word){
        if(memo.count(word)) return memo[word];

        int best = 1;
        for(int i = 0; i < word.size(); i++){
            string prev = word.substr(0, i) + word.substr(i + 1);
            if(st.count(prev)){
                best = max(best, 1 + dfs(prev));
            }
        }

        return memo[word] = best;
    }

    int longestStrChain(vector<string>& words) {
        sort(words.begin(), words.end(), [](const string &a, const string &b){
            return a.length() < b.length();
        });

        // for(auto & word: words){
        //     st.insert(word);
        // }

        int ans = 1;
        for(string word : words){
            st.insert(word);
            ans = max(ans, dfs(word));
        }

        return ans;
    }
};