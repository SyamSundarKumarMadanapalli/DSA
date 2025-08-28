class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        unordered_map<int, vector<int>> mp;
        int rows = mat.size();
        int cols = mat[0].size();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mp[i - j].push_back(mat[i][j]);
            }
        }


        for (auto& [key, vec] : mp) {
            sort(vec.begin(), vec.end(), greater<int>());  
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int diff = i - j;
                mat[i][j] = mp[diff].back();
                mp[diff].pop_back();
            }
        }

        return mat;
    }
};
