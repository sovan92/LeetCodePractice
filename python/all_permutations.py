from typing import List



def all_permutations(char_list: List['str'], result_list: List['str'] , idx: int, slate: List['str'], visited_idx: set[int]) :
    print(char_list, result_list, idx, slate, visited_idx)
    if idx == len(char_list):
        result_list.append(''.join(slate))
        return

    for i in range(len(char_list)):
        if i not in visited_idx:
            visited_idx.add(i)
            slate.append(char_list[i])
            all_permutations(char_list, result_list, idx+1, slate,  visited_idx)
            slate.pop()
            visited_idx.remove(i)


result_list = []
all_permutations(['a','b','c'], result_list, 0, [],  set())
