/*
 Bài 1: Viết function truyền vào 1 số nguyên dường. Tính giai thừa của số đó
Ví dụ: calculateFactorial(5) = 5 * 4 * 3 * 2 * 1 = 120
*/

function calculateFactorial(number) {
    let result = 1;
    for (let i = 1; i <= number; i++) {
        result *= i;
    }
    return result;
}
console.log(calculateFactorial(5));


/*
Bài 2: Viết function truyền vào 1 chuỗi. In ra chuỗi đảo ngược của chuỗi đó
Ví dụ: reverseString(‘hello’) => olleh
 */
let str = prompt('Enter a string: ');
function reverseString(str) {
    let result = '';
    for (let i = str.length - 1; i >= 0; i--) {
        result += str[i];
    }
    return result;
}
console.log(reverseString(str));



/*
Bài 3: Viết function truyền vào mã quốc gia. Trả về message có ý nghĩa là “Xin chào”, tương ứng với mã quốc gia được truyền vào
Ví dụ: translate(‘VN’) => “Xin chào”
translate(‘EN’) => “Hello”
Gợi ý : Sử dụng switch - case . Học viên tự nghĩ ra 1 vài mã quốc gia và câu chào tương ứng với quốc gia đó
*/

let country = prompt('Enter your country (VN, EN, JP, KR, FR): ');
function translate(country) {
    let message;
    switch (country) {
        case 'VN':
            message = 'Xin chao';
            break;
        case 'EN':
            message = 'Hello';
            break;
        case 'JP':
            message = 'Konichiwa';
            break;
        case 'KR':
            message = 'Annyeonghaseyo';
            break;
        case 'FR':
            message = 'Bonjour';
            break;
        default:
            message = 'Not found';
    }
    return message;
}
console.log(translate(country));




/*Bài 4: Cho function truyền vào 1 chuỗi dài hơn 15 ký tự. Viết 1 function cắt chuỗi, lấy ra 10 ký tự đầu tiên và thêm vào dấu “…” ở cuối chuỗi.
Ví dụ : subString(“xinchaocacbandenvoiTechmaster”) => “xinchaocac…”
*/
let str2 = prompt('Enter a string: ');
function subString(str) {
    let result = '';
    for (let i = 0; i < 10; i++) {
        result += str[i];
    }
    return result + '...';
}
console.log(subString(str2));