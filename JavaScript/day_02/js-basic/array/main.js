
// Bài 1: Viết function tìm số lớn nhất trong mảng
const findMax = (arr) => {
    let max = arr[0];
    arr.forEach((value) => {
        if(value > max) max = value
    });
    return max;
}

const findMax2 = (arr) => Math.max(...arr); // ES6: Spread syntax

const findMax3 = (arr) => {
    arr.sort((a, b) => b - a);
    return arr[0];
}

console.log(findMax([2,4,6,2,6,8,6,9,2,1]));

// Bài 3: Viết function cho phép truyền vào 1 mảng các số, kết quả trả về là 1 mảng mới với các số là số dư tương ứng khi chia mảng cũ cho 2
// Ví dụ : [4,2,5,6,2,7] => [0,0,1,0,0,1]

const findEven = (arr) => {
    let result = [];
    arr.forEach((value) => {
        result.push(value % 2);
    });
    return result;
}

console.log(findEven([4,2,5,6,2,7]));

// Bài 5: Viết function truyền vào 1 chuỗi, hãy sao chép đó chuỗi lên 10 lần, ngăn cách nhau bởi dấu gạch ngang (Sử dụng array để làm)
// Ví dụ: repeatString(‘a’) => Kết quả trả về là ‘a-a-a-a-a-a-a-a-a-a’

const repeatString = (str) => {
    let result = [];
    for(let i = 0; i < 10; i++) {
        result.push(str);
    }
    return result.join('-');
}

console.log(repeatString('a'));

const repeatString2 = (str) => {
    return new Array(10).fill(str).join('-');
}
console.log(repeatString2('a'));




// Bài 6: Viết function truyền vào 1 chuỗi, kiểm tra xem chuỗi đó có phải chuỗi đối xứng hay không (chuỗi đối xứng là chuỗi đọc xuôi hay ngược đều như nhau, không tính khoảng trắng, không phân biệt hoa thường), kết quả trả về true hoặc false.

const isPalindrome = (str) => {
    let result = true;
    for(let i = 0; i < str.length / 2; i++) {
        if(str[i] != str[str.length - 1 - i]) {
            result = false;
            break;
        }
    }
    return result;
}

console.log(isPalindrome('abba'));