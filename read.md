This platform has been a great help in my interview preparation, so now it’s my turn to give back. I recently prepared for the Meta E5 role and would like to share some resources with those who are preparing for Meta interviews. I have successfully cleared all the interview rounds few months ago. As I have signed an NDA with Meta, I cannot share the exact questions asked in my interviews (I’m really sorry about that!). After extensive research on Leetcode posts and finding many articles covering various details, I want to share the most relevant and updated information in this post. I hope this helps.

> Before applying
>> Deciding on roles
At Meta, there are two types of roles in Software Engineering:

Product roles: Teams that develop customer-facing products (e.g., Instagram team, Facebook team, WhatsApp team, etc.)
Infrastructure roles: Teams that create tools used by Meta’s products (e.g., Data store team, Analytics team, etc.)
First, you should decide which of the above roles suits you best. Are you a full-stack engineer interested in building customer-facing products, or are you a backend engineer focused on designing scalable systems and architecture? For E4 and higher roles, you must pass a system design interview, and the structure of your interviews will vary depending on the role you choose.

To get a better understanding I highly recommend going through these two resources:

Official video by MetaCareers on product vs system design rounds
https://www.hellointerview.com/blog/meta-system-vs-product-design
>>Deciding on level


You can use the levels.fyi level comparator to understand which level you want to target at Meta.

Once you are done with these decisions, try to find relevant openings on MetaCareers portal: https://www.metacareers.com/jobs

>Applying for roles
I applied to some openings on my own and never heard back from the recruiters. Then I asked a Meta employee to refer me for some openings that aligned with my interests, and within a few days, I started getting responses from the recruiters.

TIP: If you want to increase your chances of getting a call from the recruitment team, apply through a referral instead of applying directly.

During the call with the recruiter, they will ask questions like ‘What kind of work have you done in your recent job?’ and ‘What was the impact?’ Essentially, they want to determine if the candidate is suitable for the applied positions (E4, E5, etc.). If you are applying for E5 or higher roles, you should demonstrate some projects where you led the development team (even if you are still an SDE2 at your current company, that’s fine). Recruiters may use different terms for product and infra roles, so make sure you communicate your interests very carefully during your call.

Depending on your level of preparation, you can inform the recruiters of when you would like to have your screening round (first coding round). Meta recruiters are really supportive; they will assist you with everything and will not pressure you to rush into the interviews. They will give you as much time as you request. Therefore, I would recommend thinking of a date before your recruiter call.

>Interview process
There will be 5 rounds in total:

Step 1: Screening round - Coding round: You must clear this round before you go for full loop.
Step 2: Full loop:
Coding round 1
Coding round 2
Design round(for E4 and plus) - If you have applied for product role then this round will be called "Product design round" else it will be called "System design round".
Behavioral round
Step 3: Team matching
Step 4: Offer
Step 5: Joining
You can find details on each rounds and what to expect etc on this blog: https://www.hellointerview.com/blog/the-meta-swe-interview. But I will still share some key points below:

All the interview rounds are 45 minutes each. The interviewers will dive straight into the problem statement and will keep last 5 minutes for Q&A. So you have just 35-40 minutes to answer the questions.
All the coding rounds (Step 1, 2.1 and 2.2) and done on coderpad. So make yourself comfortable with the tool. The IntelliSense is not supported and you can't compile your code on CoderPad during your interviews.
The system design rounds are done on Excalidraw. Make sure you have done enough preparation on this tool before your main interview.
The interviews are scheduled through zoom and every update(link to the invite etc) you can find it on your MetaCareers portal.
>Preparation
The most interesting and important part of this post. I will separate this into three categories:

>Coding round preparation
You will be asked two questions. The difficulty of these questions can vary (though it is rare to see two hard questions).
You are expected to understand the problem, ask relevant clarifying questions, propose all possible solutions you can think of, select the best solution to code, code the solution, explain the time and space complexity, and run a test case against your solution (dry-run). This process has to be done for both questions. I know this may sound very intimidating. Aim to prepare in such a way that you can solve a medium complexity problem within 12-15 minutes (including thinking and coding).
Remember that coding rounds are somewhat like elimination rounds, and your level is never determined solely by the results of coding interviews. You can read more about the evaluation criteria here. If you exhibit red flags in any area (such as problem-solving) in most of your coding rounds, then you will likely be rejected. However, Meta does not down-level candidates based on coding rounds alone.
To prepare for Meta’s coding rounds, I strongly suggest solving at least the top 100 problems from the last 6 months of “Facebook” tagged questions sorted by frequency (a premium membership is required). It is highly likely that you will encounter coding questions from this list. Meta is known for asking questions that involve many edge cases, ‘if-you-haven’t-seen-this-question-before-then-you’re-gone’ type of questions, questions involving strings, and questions involving heaps. Ensure you skim through all the remaining questions on the list to see if you can solve the problems on your own. If not, at least read through the approaches and a few top solutions.

I suggest not getting demotivated if you can’t solve the questions during your preparation within an hour or so. The questions are very tricky, and it is challenging to come up with a solution and working code in just 15 minutes on your own. If you can’t solve a problem, don’t worry; read through the editorials, check a few top-voted solutions and comments, search for the question on YouTube, and watch a few top videos. I’m sure you will understand the solution after a few iterations. Don’t stop after getting an “Accepted”; spend a few more minutes thinking about some modifications for that given question. Don’t just memorize the solution; try to understand the thought process behind it. Once you’ve completed a problem, keep a note (either mental or in code comments) of what you’ve learned, because it’s likely that when you return to that question after a few days, just before your coding rounds, you won’t understand what you’ve written earlier. Keep the links to the videos/solutions handy in those notes for your revisions just before the main interview rounds.

I’m not sure how accurate this is, but I’ve read in many posts that Meta doesn’t often ask Dynamic Programming questions. So, you may consider skipping the DP problems.

For coding, LeetCode is the key to success. Don’t forget to read the comments section to see what fellow coders say about what the Meta interviewer expected from them for a particular problem.

During your interviews, if you encounter a problem you’ve already solved, don’t get too excited and jump directly to the solution. Take a few moments to think (or recall what the solution was :) ) and then try to explain as many approaches as you can think of. I would suggest writing all the approaches in just a few words (maybe 5-7 words) along with their time and space complexities on coderpad. Only proceed coding the solution you believe is the best, prioritizing time complexity first and then space complexity. The interviewer might ask you to write the second-best solution (whatever solution they are aware of), so be prepared for this and don’t jeopardize your chances by knowing only the most optimal solution and not the sub-optimal ones.

TIP: You will be evaluated based on what you have written on the coderpad. The interviewer might forget what you said verbally during the interview because interviewers often don’t fill out your feedback immediately after the interview. They will open your coderpad link and then try to recollect what you told them during the interview. So whenever you tell something important to the interviewer during the interview, write it down on the codepad/excalidraw for the interviewer to read it once they are filling your feedback

>Behaviour round preparation
This is a comparatively easy round as it is non-technical. However, there is still a high chance of being down-leveled based on the answers you provide to the interviewer. Therefore, you must choose examples that are relevant to your level. If you are interviewing for an E5 or higher level and the interviewer asks, ‘Tell me about a time when you had a conflict with your manager,’ avoid responses like ‘I had a conflict with my manager because I said a bug would take five days to fix, but my manager insisted on three days.’ Your answers should reflect scale, ownership, relevance, and leadership skills. There are no predefined sets of questions you can prepare for before your interview.

To prepare for this round, first review the leadership principles that Meta follows here. Then, document all the work you have done in the past five years or so. Next, think of scenarios relevant to your level that align with Meta’s leadership principles. Use a STAR (Situation-Task-Action-Result) approach when crafting your stories.

I highly recommend the Story-Builder tool created by the HelloInterview website. You can input answers to the questions asked by this AI tool, and you will receive a nicely summarized story at the end. Prepare a story for each of the six competencies provided.

Note: I am not affiliated with HelloInterview in any form, nor do I receive any benefits (monetary or otherwise) from this platform. I used this platform to prepare for Meta interviews, and it was very helpful. Therefore, I want to express my gratitude to the content creators of this platform by sharing it with all of you.

In cases where one story applies to multiple competencies, I suggest preparing more than one story for each competency. Meta appreciates numbers—revenue impact, customer impact, reduction in the number of clicks, percentage of performance improvement, etc. Ensure your stories include these impactful numbers.

Ultimately, the interviewer will assess you based on the answers you provide to situational questions. If they are hiring for a senior (E5) role, your answers should clearly demonstrate that ‘Yes, I can lead my team members, I lead by example, I can help my team succeed, I can handle ambiguity, and I can think big." I hope you got my point. This round is crucial for determining your level, so prepare thoroughly.

>Design round preparation
Now comes the most interesting round: ‘The Design Round.’ I know it’s hard to find relevant information on this topic over the internet at one place. This round is a level decider like behaviour round, so there’s a high chance of being down-leveled if you don’t design your system according to the expected level. Before we dive deep into the preparation strategy, I want you to review these resources first:

Official video by MetaCareers on product vs system design rounds
Meta product design vs system design round difference
What is expected at each level
To summarize in my own words:

Product design rounds primarily focus on how you build solutions keeping in mind how customers are using your system. How will the data flow from the customer’s application endpoint through your designed APIs, interact with various services, and finally reach the data stores? How do all services interact? How do you design your databases? How do you identify various pitfalls in your system while keeping user scenarios in mind (e.g., heavy reads, heavy writes, celebrity issues in social networking apps, etc.)? How do you make sure your system will still run in low networks? How you will make sure you can prevent your system from bad actors (attackers)? Don’t focus on how you will shard your system to scale, how consistent hashing will help your system, or how components like Load Balancers or Redis Queues work. Think like a full-stack engineer, not just as a backend engineer.

System design (infra roles) rounds focus on the depth of the components. How much volume of requests your system is receiving? How will you handle this much QPS (Queries Per Second)? Which database will you use, and how will you partition it? What will happen if one of your components goes down? How do different design methodologies benefit your system for a given problem statement? Think in depth. Think as a backend engineer, not as a full-stack engineer.

Here are a few examples to conclude this discussion on differences:

Product design (product roles): Design Netflix, design Instagram, design Facebook’s news feed, etc.
System design (infra roles): Design a web crawler, design a distributed scheduler, design an ad-click aggregation system, etc.
There may be instances where the same problem statement is asked in both product and system design rounds. But I think you now have a good idea of how to structure your design. So, with the above points in mind, you can review this LeetCode article and filter the questions depending on which design round you are preparing for.

I have personally prepared for the product design round, so I don’t know much about system design rounds (infra). Therefore, I am sharing my product design round preparation strategy below. I request someone from the audience to post the system design strategy, which I will later add to this post.

For both rounds, it is essential to compare multiple approaches and discuss the pros and cons of each while making any design choices during your design round. Meta interviewers do not expect you to provide the exact correct answer they have in mind, but they do expect you to evaluate all available approaches and have a clear understanding of why you are choosing design option A over design option B.

If you are interviewing for an E5 or higher position, Meta expects you to lead the entire discussion. Think like a startup founder who is designing their product—their own ‘baby’—and own everything end-to-end. You need to come up with approaches, understand common pitfalls, propose different approaches, decide what APIs you would like to expose, and identify critical areas for a deep dive, saying, ‘This is a very important piece of the puzzle, so I want to delve deeper into this area.’ You should prepare 2-3 deep dives for each question.

Since there are no right or wrong answers in the design round, how you communicate and deliver your ideas is crucial. I strongly recommend to do some mock interviews with your friends and seniors, record the sessions, watch how you performed, get feedback from the mock interviewer, and identify areas for improvement. This approach has helped me a lot in my preparation, and I hope it helps you as well.

The discussion time is just 35-40 minutes, I know it is very easy for you to spend more than required time on a single topic. Keep in mind that you will be judged on what diagrams you have drawn on Excelidraw and what notes you have written there. So first prioritise drawing the high level design on the tool, defining the APIs: telling the request and response body for atleast one of the important ones. And then talk about the details. You have to manage your time very efficiently. The interviewer may not intervene much during the interview, so nudge them and ask if they are following or have any questions till that point. If they give you any feedback or try to go deep in some area, follow their direction.

>Product design round preparation strategy

Follow this framework mentioned here to structure your design: Requirement gathering (5 mins), Defining core entities(2 mins), API Design(5 mins), High level design(15 minutes), Deep dives(10 minutes)
There are some concepts related to API design which you should know:
How do you design your APIs. Resources: blog post,API for beginners YouTube video.
Concepts involving API design like Pagination, rate limiting, different HTTP interfaces to write an API(RPC, SOAP, REST, GraphQL). Resources: Search on YouTube.
There are some commonly used design patterns which are used:
For very high incoming traffic how you can use queue based approach to handle load at peak time. Example problem: Design ticketmaster. Solution: YouTube video by HelloInterview, this blog. Also this concept can be used during peak traffic of users posting content on social media etc.
To upload large data on object store, how you can use Amazon S3 (or any other object store), how predefinedURL works, how you store and metadata of that large data accordingly. Example problem: Designing Dropbox. Solution: this blog
How to use Redis for proximity searches? Sample problem: Design Uber, solution: this blog
For celebrity scenarios on social media how you can use fan-on-read for celebrity posting content instead of fan-on-write for non-celebrity users. Sample problems: Design Twitter feed, instagram feed, facebook feed etc. Solution: YouTube video by HelloInterview on Design twitter, this blog post,
For efficient searches over a lot of data, you can use ElasticSearch. Sample problem: Searching for a tweet by content. Solution: this blog post
For systems which involves video steaming, we should build a processing queue and background workers to convert each uploaded video to different formats and resolutions to make it compatible with different kinds of devices and cater different network bandwidths. Example problem: Design netflix or tiktok or YouTube. Solution: YouTube video by GKCS
OLAP vs OLTP. What is ETL? How to use MapReduce in the problems which involves some background analysis of a data, Example problem: Generating a leaderboard offline. Resources: OLAP vs OLTP Youtube Video, What is ETL, How MapReduce works, Application of these concepts: Design online coding judge 1, Design online coding judge 2


>Common Design Questions
Ad click aggregation system
Top 10 songs played on spotify (top-k problem)
Design web crawler
Design a system to store images for FB and insta that would require 1000 uploads per sec and handle duplication.
Deisgn online chess
Design whatsapp
Design price alert system similar to camelcamelcamel.com
Design proximity server.
Design YouTube.
Design the Facebook post privacy functionality. In other words, if I make a Facebook post, and I have 3 privacy options to choose from (Only Me, Friends Only, Public), design how wold you get the visibility for any Faceook user (ie. can a FB user see the post or not)
Design an online judge like leetcode.
Video count in distributed system.
2.Design Ticketmaster.
More focus on:
Ticket booking workflows
What if tickets are not available?
Design News Feed
job scheduler
dropbox
You have an app and you want to design an i18n system for them. When the user changes languages, all the strings have to change to that specific language.
file downloader library 




>Behavioral Interview (1 session, 45 minutes)

The Behavioral interview at Meta is a 45-minute session where interviewers look at your past behaviors, actions, and decisions in a work environment. The goal is to understand your work habits, your interests in technology, and the impact you want to make.

What To Expect
Inquisitive Deep Dive: Expect the interviewer to delve into your background, discerning what ignites your passion in tech, and understanding the kind of impact you aim to create.
Expansive Questions: Be ready to traverse through various aspects of your past and current projects, discussing specific scenarios, impacts, and gleaned learnings.
Tales of Growth and Conflict: You’ll likely be asked to narrate instances of conflicts and your journey of continual professional and personal growth.
Examples of areas they might probe into:

Disagreements with colleagues or managers and your resolution tactics.
Scenarios where you sought out growth opportunities or tackled constructive criticism.
Instances where ambiguity was embraced and navigated through.
Evaluation Criteria
Your narrative and examples will be analyzed through the lens of five critical signals that have historically correlated with success at Meta:

Resolving Conflict:

Your history of disagreements and resolutions.
Your capacity to empathize with divergent viewpoints.
Growing Continuously:

Your propensity for identifying and seizing growth and learning opportunities.
Your receptiveness and action towards constructive criticism.
Embracing Ambiguity:

Your operational strategy within ambiguous and swiftly altering environments.
Your decision-making and productivity maintenance amidst information scarcity.
Driving Results:

Your experience and strategy in propelling yourself and others towards goal attainment.
Demonstrating your impact and maneuvering through challenges and obstacles.
Communicating Effectively:

Your communicative adaptability with teams and cross-functional partners.
Your strategy for tailoring communications contingent on the work and audience.











The HelloInterview design resources are very relevant for preparing for Meta product design rounds. I would highly encourage you to go through all the articles written on HelloInterview. I have seen there is an AI tool to solve design problems on that platform itself, but I haven't used it personally so I can't comment on it.

Thank you for reading and wish you good luck for your interviews!