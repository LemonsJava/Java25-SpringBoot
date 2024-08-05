// Viết function truyền vào mảng các chuỗi có độ dài bất kỳ. Kết quả trả về là 1 mảng các chuỗi có độ dài lớn nhất

const str = ["aba", "aa", "ad", "c", "vcd"];

function findLongestWord(str) {
  let maxStr = str[0].length;
  for (let i = 0; i < str.length; i++) {
    if (str[i].length > maxStr) {
      maxStr = str[i].length;
    }
  }
  return str.filter((value) => value.length == maxStr);
}

console.log(findLongestWord(str));
