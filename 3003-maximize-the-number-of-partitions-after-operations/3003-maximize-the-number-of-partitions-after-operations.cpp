class Solution {
public:
    int maxPartitionsAfterOperations(string s, int k) {
        int n = s.length();
        vector<int> setBits(n);
        
        for (int i = 0; i < n; i++) {
            setBits[i] = 1 << (s[i] - 'a');
        }
        
        auto makePrefix = [&](vector<int> bits) {
            vector<int> prefix = {0};
            vector<int> prefixMask = {0};
            int mask = 0, groups = 0;
            
            for (int bit : bits) {
                mask |= bit;
                if (__builtin_popcount(mask) > k) {
                    groups++;
                    mask = bit;
                }
                prefix.push_back(groups);
                prefixMask.push_back(mask);
            }
            
            return make_pair(prefix, prefixMask);
        };
        
        auto [prefix, prefixMask] = makePrefix(setBits);
        
        reverse(setBits.begin(), setBits.end());
        auto [suffix, suffixMask] = makePrefix(setBits);
        
        int maxParts = 0;
        
        for (int i = 0; i < n; i++) {
            int candidate = prefix[i] + suffix[n - i - 1];
            int leftMask = prefixMask[i];
            int rightMask = suffixMask[n - i - 1];
            int combined = leftMask | rightMask;
            
            if (min(__builtin_popcount(combined) + 1, 26) <= k) {
                candidate += 1;
            } else if (__builtin_popcount(leftMask) == k && 
                       __builtin_popcount(rightMask) == k && 
                       __builtin_popcount(combined) < 26) {
                candidate += 3;
            } else {
                candidate += 2;
            }
            
            maxParts = max(maxParts, candidate);
        }
        
        return maxParts;
    }
};