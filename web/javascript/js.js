function delQuestion(QuestionID, currentPage) {
    result = confirm("Are you sure to delete this question ?");
    //click "OK"
    if (result)
        //
        window.location.replace("deleteQuestion?delID=" + QuestionID + "&currentPage=" + currentPage);
    //window.location.replace("manageQuiz?index=" + pageIndex + "&delID=" + QuestionID);
}

function countDown(time) {
    myVar = setInterval(function () {
        time--;
        var minute = Math.floor(time / 60);
        var sec = time % 60;

        //stop countdown prevent time return negative number
        if (time === 0) {
//            document.getElementById("quizForm").submit();
            clearInterval(myVar);
        }
        //return to screen by  id named : timeDisplay
        document.getElementById("timeDisplay").innerHTML = minute + ":" + sec;
    }, 1000);
}

//create variable
this.currentQuiz = -1;
this.currentDiv = null;
function nextQuestion(numOfQuiz) {
    //next quiz
    currentQuiz = (currentQuiz + 1) % numOfQuiz;
    //adding hudden class to the previous question
    if (currentDiv !== null) {
        currentDiv.classList.add("hidden");
    }
    //get current quiz
    currentDiv = document.getElementById("q" + currentQuiz);
    //show quiz by removing hidden class
    currentDiv.classList.remove("hidden");

    document.getElementById("currentQuiz").innerHTML = "Question: " + (currentQuiz + 1) + "/" + numOfQuiz;
}
