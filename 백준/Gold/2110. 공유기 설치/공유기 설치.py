n, c = map(int, input().split())
nums = [int(input()) for _ in range(n)]
nums.sort()

distances = []

start = 1
end = nums[-1] - nums[0]
result = 0

while start <= end:
    mid = (start + end) // 2
    value = nums[0]
    count = 1
    for i in range(1, n):
        if nums[i] >= value + mid:
            value = nums[i]
            count += 1
    if count >= c:
        start = mid + 1
        result = mid
    else:
        end = mid - 1

print(result)