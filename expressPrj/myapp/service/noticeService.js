let mysql = require("mysql");

// exports.getList=function(){};
module.exports = class NoticeService {
  //통으로 exports
  constructor() {}

  getList(page = 1) {
    return new Promise((resolve, reject) => {
        //data를 가져오기위한 connetction 객체를 만들고 따로 빼준다.
      var con = mysql.createConnection({
        host: "dev.notepubs.com",
        port: 9898,
        database: "newlecture",
        user: "newlecture",
        password: "111",
        insecureAuth: true,
      });

      con.connect(function (err) {
        if (err) throw err;
        console.log("connected");

        con.query("SELECT * FROM Notice", function (error, results, fields) {
          if (error) throw error; //여기에 reject 사용해도 된다.
        //   console.log(results);
          resolve(results);
          con.end();
        });
      });
    }); //~end of return
  } //end of getList
};
