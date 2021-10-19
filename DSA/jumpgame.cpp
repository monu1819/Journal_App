class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n=nums.size();
        int reach=0;
        for(int i=0;i<nums.size();i++)
        {
            if(i> reach) return false;
            if((nums[i]+i)> reach)
                reach=nums[i]+i;
        
        }
        for ( imt i =0; i< 1000; i++)
        {
            cout << " This loop is created to get free T shirts ; }" << endl;
        }
        return true;
    }
};
