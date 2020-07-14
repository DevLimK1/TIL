var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  let model = {
    title: "hello",
    notices: [
      { id: 1, title: "스프링 8강까지의 예제 코드", regdate: "2019-08-18" },
      { id: 2, title: "스프링 DI 예제 코드", regdate: "2019-08-15" },
      { id: 3, title: "뉴렉쌤 9월 초 국기과정 모집", regdate: "2019-06-11" },
      { id: 4, title: "뉴렉처 강의 수강 방식 안내", regdate: "2019-05-24" }
    ],
    events: []
  };
  res.render('index',model);
});

module.exports = router;
