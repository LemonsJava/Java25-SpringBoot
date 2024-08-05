// Vừa vào trang hiển thị danh sách quiz (bao gồm tiêu đề và danh sách các câu trả lời)
// Khi bấm vào nút “Random Answer” thì random câu trả lời cho từng câu hỏi và tự động được check vào (Mỗi câu hỏi chỉ check 1 câu trả lời)
// Cấu trúc quiz để render xem trong link tham khảo
// Khi render chú ý thuộc tính name trong các ô input, các câu trả lời cho cùng 1 câu hỏi, cần có name giống nhau

const quizes = [
  {
    id: 1,
    question: "1 + 1 = ?",
    answers: [1, 2, 3, 4],
  },
  {
    id: 2,
    question: "2 + 2 = ?",
    answers: [2, 3, 4, 5],
  },
  {
    id: 3,
    question: "3 + 3 = ?",
    answers: [3, 4, 5, 6],
  },
];

const renderQuestion = (quizes) => {
  const quizItem = document.querySelector(".quiz-container");
  let html = "";
  quizes.forEach((quiz) => {
    html += `
    <div class="quiz-item">
      <h3>Câu ${quiz.id} : ${quiz.question}</h3>
      <div class="quiz-answer">
        <div class="quiz-answer-item">
          <input type="radio" name="${quiz.id}">
          <label>${quiz.answers[0]}</label>
        </div>
        <div class="quiz-answer-item">
          <input type="radio" name="${quiz.id}">
          <label>${quiz.answers[1]}</label>
        </div>
        <div class="quiz-answer-item">
          <input type="radio" name="${quiz.id}">
          <label>${quiz.answers[2]}</label>
        </div>
        <div class="quiz-answer-item">
          <input type="radio" name="${quiz.id}">
          <label>${quiz.answers[3]}</label>
        </div>
      </div>
      `;
  });
  quizItem.innerHTML = html;
};
renderQuestion(quizes);

const btn = document.getElementById("btn");

btn.addEventListener("click", randomAnswers);

function randomAnswers() {
  const quizItems = document.querySelectorAll(".quiz-item");

  quizItems.forEach((quizItem) => {
    const answers = quizItem.querySelectorAll('input[type="radio"]');
    const randomIndex = Math.floor(Math.random() * answers.length);
    answers[randomIndex].checked = true;
  });
}
