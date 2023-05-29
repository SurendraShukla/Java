package me.surendra.leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/accounts-merge/">Accounts Merge</a>
 */
public class AccountsMerge {

    public List<List<String>> accountsMergeUsingFindUnion(List<List<String>> accounts) {
        final DSU dsu = new DSU();
        final Map<String, String> emailToName = new HashMap();
        final Map<String, Integer> emailToID = new HashMap();
        int id = 0;
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        final Map<Integer, List<String>> ans = new HashMap();
        for (String email: emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            ans.computeIfAbsent(index, x-> new ArrayList()).add(email);
        }
        for (List<String> component: ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(ans.values());
    }

    /*
        Time Complexity - O(n)
        Space Complexity - O(n)
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        final Map<String, String> emailAccountMap = new HashMap<>();
        final Map<String, List<String>> accountEmailMap = new HashMap<>();

        for (int i=0; i<accounts.size(); i++) {

            final List<String> accountInfo = accounts.get(i);
            final String accountName = accountInfo.get(0) + "#" + i;

            for (int j = 1; j < accountInfo.size(); j++) {
                final String emailId = accountInfo.get(j);
                final List<String> emailIds = accountEmailMap.getOrDefault(accountName, new ArrayList<>());

                if (emailAccountMap.containsKey(emailId)) {
                    final String oldAccountName = emailAccountMap.get(emailId);
                    if (!oldAccountName.equals(accountName)) {
                        final List<String> tmpEmailIds = accountEmailMap.get(oldAccountName);
                        for (final String tmpEmailId : tmpEmailIds) {
                            emailAccountMap.put(tmpEmailId, accountName);
                        }
                        emailIds.addAll(tmpEmailIds);
                        accountEmailMap.remove(oldAccountName);
                    }
                    accountEmailMap.put(accountName, emailIds);
                }else{
                    emailAccountMap.put(emailId, accountName);
                    emailIds.add(emailId);
                    accountEmailMap.put(accountName, emailIds);
                }
            }
        }

        final List<List<String>> returnAccountInfo = new ArrayList<>();
        for (final Map.Entry<String, List<String>> tmpEmailAccountMap : accountEmailMap.entrySet()) {
            final List<String> tmpList = new ArrayList<>();
            final String accountName = tmpEmailAccountMap.getKey().split("#")[0];
            tmpList.add(accountName);
            final List<String> emailIds = tmpEmailAccountMap.getValue();
            Collections.sort(emailIds);
            tmpList.addAll(emailIds);
            returnAccountInfo.add(tmpList);
        }

        return returnAccountInfo;

    }


    class DSU {
        int[] parent;
        DSU() {
            parent = new int[10001];
            for (int i = 0; i <= 10000; ++i)
                parent[i] = i;
        }
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }


}
