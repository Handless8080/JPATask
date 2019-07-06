use `students`;

show tables;

describe `student`;
describe `student_result`;
describe `exam`;
describe `exam_result`;
describe `techer`;
describe `training_course`;

select * from `student` where `id` = 1;
select * from `student_result` where `student_id` = 1;