use std::collections::{HashMap, VecDeque};

impl Solution {
    pub fn largest_path_value(colors: String, edges: Vec<Vec<i32>>) -> i32 {
        let n = colors.len();
        let mut degrees = vec![0; n];
        let mut map: HashMap<i32, Vec<i32>> = HashMap::new();
        
        for i in 0..n {
            map.insert(i as i32, Vec::new());
        }
        
        for edge in &edges {
            let from = edge[0];
            let to = edge[1];
            map.get_mut(&from).unwrap().push(to);
            degrees[to as usize] += 1;
        }
        
        let mut queue: VecDeque<i32> = VecDeque::new();
        
        for i in 0..n {
            if degrees[i] == 0 {
                queue.push_back(i as i32);
            }
        }
        
        let mut res = 0;
        let mut node_count = 0;
        let mut dp = vec![vec![0; 26]; n];
        
        while !queue.is_empty() {
            if let Some(p) = queue.pop_front() {
                node_count += 1;
                dp[p as usize][colors.as_bytes()[p as usize] as usize - b'a' as usize] += 1;
                res = res.max(dp[p as usize][colors.as_bytes()[p as usize] as usize - b'a' as usize]);
                
                if let Some(neighbors) = map.get(&p) {
                    for &next in neighbors {
                        for i in 0..26 {
                            dp[next as usize][i] = dp[next as usize][i].max(dp[p as usize][i]);
                        }
                        degrees[next as usize] -= 1;
                        if degrees[next as usize] == 0 {
                            queue.push_back(next);
                        }
                    }
                }
            }
        }
        
        if node_count < n as i32 {
            -1
        } else {
            res
        }
    }
}