@Echo off

REM this cmd will pull the image ffmeg which convert the video to gif and put it into mapped volume
docker run --rm --volume %cd%:/output jrottenberg/ffmpeg -i http://bit.ly/2fcrRK2 /output/Turkey.gif